package org.es.zolbareshet.queries;

import org.es.zolbareshet.logging.Logger;
import org.es.zolbareshet.logging.LoggerFactory;
import org.es.zolbareshet.logging.MainLogger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.util.Arrays;



public class QueriesHandler {
    private  static DataSource ds;
    private  static Logger logger = LoggerFactory.getLogger();


    static{
                try {
                    Context ctx = new InitialContext();
                    ds = (DataSource)ctx.lookup("java:comp/env/jdbc/zol");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    public static  boolean creatingQuery(String query,String[] parameters){
        Connection con=null;
        ResultSet result=null;
        abstractQuery( con, result,  query,parameters);

        boolean res =false;
        try {
            res = (result==null)|| (!result.next());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    public static  boolean checkingQuery (String query,String[] parameters){
        Connection con=null;
        ResultSet result=null;
        abstractQuery( con, result,  query,parameters);
        boolean res =false;
        try {
            res = (result==null)|| (!result.next());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }


    public  static ResultSet getResultQuery (String query, String[] parameters){
        Connection con=null;
        ResultSet result=null;
        abstractQuery( con, result,  query, parameters);
        return result;
    }



    public static void abstractQuery(Connection con,ResultSet result, String query, String[] parameters){
        try {
            con = ds.getConnection();
            PreparedStatement prep = con.prepareStatement(query) ;
            if (parameters!=null) {
                for (int i = 0; i < parameters.length; i++) {
                    prep.setString(i + 1, parameters[i]);
                }
            }
            prep.executeQuery();
            logger.log(MainLogger.LEVEL.DEBUG,"query: "+ query + " was successfully invoked");
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
    }


}


