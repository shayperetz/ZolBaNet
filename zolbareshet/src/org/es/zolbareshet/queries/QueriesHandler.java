package org.es.zolbareshet.queries;

import com.sun.deploy.security.ValidationState;
import org.es.zolbareshet.logging.Logger;
import org.es.zolbareshet.logging.LoggerFactory;
import org.es.zolbareshet.logging.MainLogger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.*;
import java.sql.Date;
import java.util.*;


public class QueriesHandler {
    private  static DataSource ds;
    private  static Logger logger = LoggerFactory.getLogger();


    static{
                try {
                    Context ctx = new InitialContext();
                    ds = (DataSource)ctx.lookup("java:comp/env/jdbc/postgres");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }




public static ArrayList<ResultLine> qHandler(String query, Parameter[] parameters, Parameter.TYPE[] resultType){
    return handler(query,parameters,resultType,false);
}

    public static ArrayList<ResultLine> updateQuery(String query, Parameter[] parameters){
        return handler(query,parameters,null,true);
    }

    public  static ArrayList<ResultLine> handler(String query, Parameter[] parameters, Parameter.TYPE[] resultType, boolean updateQuery){
        Connection con=null;
        ResultSet result;
        ArrayList<ResultLine> resultObjects=null;
        try {
            con = ds.getConnection();
            PreparedStatement prep = con.prepareStatement(query) ;
            if (parameters!=null) {
                for (Parameter p:parameters) {
                    switch (p.getType()){
                        case STRING:
                            prep.setString(p.getIndex(),(String)p.getObject());
                            break;
                        case INT:
                            prep.setInt(p.getIndex(),(Integer)p.getObject());
                            break;
                        case LONG:
                            prep.setLong(p.getIndex(),(Long) p.getObject());
                            break;
                        case FLOAT:
                            prep.setFloat(p.getIndex(),(Float) p.getObject());
                            break;
                        case BLOB:
                            prep.setBlob(p.getIndex(),(Blob) p.getObject());
                            break;
                        case DATE:
                            prep.setDate(p.getIndex(),(Date) p.getObject());
                            break;
                        case BOOLEAN:
                            prep.setBoolean(p.getIndex(),(Boolean) p.getObject());
                            break;
                        case BYTES:
                            prep.setBinaryStream(p.getIndex(),(FileInputStream) p.getObject(),p.getFileLength());
                            break;
                    }
                }
            }
            if(!updateQuery) {
                result = prep.executeQuery();
                resultObjects = TraverseResultSet(result, resultType);
                logger.log(MainLogger.LEVEL.DEBUG, "query: " + query + " was successfully invoked");
            }
            else {
                prep.executeUpdate();
            }
        } catch (SQLException e) {
            logger.log(MainLogger.LEVEL.WARNING,"There was a problem with the  query: "+ query + ", for more info check the stack trace:\n" + Arrays.toString(e.getStackTrace()));
        }
        finally {
            if (con!=null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return resultObjects;
    }

    public static ArrayList<ResultLine> TraverseResultSet (ResultSet rs, Parameter.TYPE[] types){
        ArrayList<ResultLine> result = new ArrayList<>();
        try {
            while (rs.next()){
                ArrayList<Object> line = new ArrayList<Object>();
                for (int i=0;i<types.length;i++) {
                    switch (types[i]) {
                        case STRING:
                            line.add(rs.getString(i + 1));
                            break;
                        case INT:
                            line.add(((Integer)rs.getInt(i + 1)).toString());
                            break;
                        case LONG:
                            line.add(((Long)rs.getLong(i + 1)).toString());
                            break;
                        case FLOAT:
                            line.add(((Float)rs.getFloat(i + 1)).toString());
                            break;
                        case BLOB:
                            line.add(((Blob)rs.getBlob(i + 1)).toString());
                            break;
                        case DATE:
                            line.add(((Date)rs.getDate(i + 1)).toString());
                            break;
                        case BOOLEAN:
                            line.add(((Boolean)rs.getBoolean(i + 1)).toString());
                            break;
                        case BYTES:
                            line.add(((byte[])rs.getBytes(i + 1)));
                            break;
                    }

                }
                result.add(new ResultLine(line));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static class ResultLine{

        private ArrayList<Object> content; //will be always String except when getting image

        public ResultLine(ArrayList<Object> content) {
            this.content = content;
        }

        public ArrayList<Object> getContent() {
            return content;
        }

        public void setContent(ArrayList<Object> content) {
            this.content = content;
        }


    }


}


