package RequestFromDataBase;

import ProjectEntities.Address;
import ProjectEntities.PhoneNumber;
import ProjectEntities.User;
import static ServerInstallation.DataBaseInstaller.ReadQuery;
import ServerInstallation.getInstallationConfig;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author peretzs
 */
public class DataUsers {
    
     public static boolean isUserExist(String USER)
    {
     String query = "SELECT username\n" +  "from users\n"+  "where username = " ;  
     String tag = "'" ;
     final String DataBaseURL = getInstallationConfig.getDataBaseURL(); 
     final String DataBaseUserName = getInstallationConfig.getDataBaseUserName(); 
     final String Password = getInstallationConfig.getDataBasePassword();       
     try ( Connection connection = DriverManager.getConnection(DataBaseURL  , DataBaseUserName , Password);    
         Statement stmt = connection.createStatement();  ResultSet res = stmt.executeQuery(query + tag + USER + tag ) ) 
     {
         String user = null  ;
         while ( res.next())
         {
            user  = (String)res.getObject(1) ;
            if ( USER.equals(user) )
            return true ; 
            else return false ; 
         }
     }  
         catch (SQLException sqlException)
        {
            System.err.println("Got an exception while tring to request user name  ");
            sqlException.printStackTrace();
        }         
       return false ; 
    }
     
     
     
   public static User getUserDetails(String userName)
    {
        
     if (isUserExist(userName) )
     {
            String query = "SELECT *\n" +  "from users\n"+  "where username = " ;  
            String tag = "'" ;
            User user = new User () ; 
            final String DataBaseURL = getInstallationConfig.getDataBaseURL(); 
            final String DataBaseUserName = getInstallationConfig.getDataBaseUserName(); 
            final String Password = getInstallationConfig.getDataBasePassword();       
            try ( Connection connection = DriverManager.getConnection(DataBaseURL  , DataBaseUserName , Password);    
                Statement stmt = connection.createStatement();  ResultSet res = stmt.executeQuery(query + tag + userName + tag ) ) 
            {

                while ( res.next())
                {
                  
                   user.setFirstName( (String)res.getObject(2)  ); 
                   user.setLastName ( (String)res.getObject(3)  ); 
                   user.setPassword ( (String)res.getObject(4)  ); 
                   user.setActive   ( (boolean)res.getObject(5) );
                   Address UserAddress = new Address ( (String)res.getObject(6), (String)res.getObject(7), (String)res.getObject(8), (String)res.getObject(9), (int)res.getObject(10)) ;
                   //UserAddress.toString();
                   user.setAddress(UserAddress);
                   PhoneNumber userNumbers = new PhoneNumber();
                   userNumbers = getUserPhoneNumbers(userName) ; 
                   user.setPhoneNumbers(userNumbers);
                   user.setEmail    ( (String)res.getObject(11) );               
                   user.setUserType ( (int)res.getObject(13)    );
                   user.setGender   ( (int)res.getObject(14)    );
                   System.out.println( user.toString());
                   return user ; 
                }
            }  
                catch (SQLException sqlException)
               {
                   System.err.println("Got an exception while tring to request user name  ");
                   sqlException.printStackTrace();
               }         
              return null  ; 
           }
     else return null ; 
    }
     
     
     public static PhoneNumber getUserPhoneNumbers(String USER)
    {
     String query = "SELECT *\n" +  "from phonenumber\n"+  "where username = " ; 
     String tag = "'" ;
     final String DataBaseURL = getInstallationConfig.getDataBaseURL(); 
     final String DataBaseUserName = getInstallationConfig.getDataBaseUserName(); 
     final String Password = getInstallationConfig.getDataBasePassword();       
     try ( Connection connection = DriverManager.getConnection(DataBaseURL  , DataBaseUserName , Password);    
         Statement stmt = connection.createStatement();  ResultSet res = stmt.executeQuery(query + tag + USER + tag ) ) 
     {
        
         while ( res.next())
         {
            PhoneNumber userPhone = new  PhoneNumber  (  (String)res.getString(2) , (String)res.getString(3) , (String)res.getString(4) , (String)res.getString(5) )  ;
            return userPhone ; 
         }
     }  
         catch (SQLException sqlException)
        {
            System.err.println("Got an exception while tring to request user name  ");
            sqlException.printStackTrace();
        }         
       return null ; 
    }
     
     
     
     
 /*   public static boolean setUser (User USER)
    {
        
     if (isUserExist( USER.getUserName()))
     {
         return false ;
     }
     else  { 
     String tag = "'" ;
     String query = "insert into users (username  , firstname, lastname , password , isactive , country , city , street,housenumber, zipcode , email , birthdate ,usertype,gender)  values ( " + tag + USER.getUserName() + tag  +" , 'shay'   , 'peretz' , '12345' , true  , 'israel' , 'pardes-hanna' ,'telTzvi' ,'3' , 36666 ,'shay@gmail.com', '1982-06-26', 1 ,1)"; 
     
     final String DataBaseURL = getInstallationConfig.getDataBaseURL(); 
     final String DataBaseUserName = getInstallationConfig.getDataBaseUserName(); 
     final String Password = getInstallationConfig.getDataBasePassword();       
     try ( Connection connection = DriverManager.getConnection(DataBaseURL  , DataBaseUserName , Password);    
         Statement stmt = connection.createStatement();  ResultSet res = stmt.executeQuery(query ) ) 
     {
         String user = null  ;
         while ( res.next())
         {
            user  = (String)res.getObject(1) ;
            if ( USER.equals(user) )
            return true ; 
            else return false ; 
         }
     }  
         catch (SQLException sqlException)
        {
            System.err.println("Got an exception while tring to request user name  ");
            sqlException.printStackTrace();
        }         
       return false ; 
     }
    }*/
     
}


//300316