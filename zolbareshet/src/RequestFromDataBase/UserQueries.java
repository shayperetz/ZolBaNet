/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package RequestFromDataBase;
import ProjectEntities.User;
import ServerInstallation.getInstallationConfig;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager ; 
import java.sql.PreparedStatement;
import java.sql.ResultSet; 
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author peretzs
 */

public class UserQueries {
  private Connection connection ; 
  private PreparedStatement insertNewUser ; 
  final String DataBaseURL = getInstallationConfig.getDataBaseURL(); 
  final String DataBaseUserName = getInstallationConfig.getDataBaseUserName(); 
  final String Password = getInstallationConfig.getDataBasePassword(); 
  public UserQueries ()
  {
      try
      { 
          connection = DriverManager.getConnection(DataBaseURL,DataBaseUserName,Password) ;
          insertNewUser = connection.prepareStatement("insert into users (username,firstname,lastname,password,isactive,country,city,street,housenumber,zipcode,email,birthdate,usertype,gender) " +
                                                      "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)" ) ;
      } 
      catch (SQLException ex)
      {
          Logger.getLogger(UserQueries.class.getName()).log(Level.SEVERE, null, ex);
      }
  }
  
  public int addUser(User user )
  {
      int results = 0 ; 
      if (!DataUsers.isUserExist(user.getUserName()))
      {
      try 
      {
          System.out.println("- * - * - * - * -"+ user.toStringBirthDate());
          insertNewUser.setString(1,user.getUserName()                  );
          insertNewUser.setString(2,user.getFirstName()                 );
          insertNewUser.setString(3,user.getLastName()                  ); 
          insertNewUser.setString(4,user.getPassword()                  );
          insertNewUser.setBoolean(5, user.getIsActive()                );          
          insertNewUser.setString(6,user.getAddress().getCountry()      );
          insertNewUser.setString(7,user.getAddress().getCity()         );
          insertNewUser.setString(8,user.getAddress().getStreet()       );
          insertNewUser.setString(9,user.getAddress().getHouseNumber()  );
          insertNewUser.setInt   (10,user.getAddress().getZipCode()     );
          insertNewUser.setString(11,user.getEmail()                    );
          insertNewUser.setDate  (12, Date.valueOf(user.toStringBirthDate())        );
          insertNewUser.setInt(13,user.getUserType()                    );
          insertNewUser.setInt(14,user.getGender()                      );
          results = insertNewUser.executeUpdate();
          System.out.println("results of add user = " + results );
      } 
        catch (SQLException ex) 
        {
          Logger.getLogger(UserQueries.class.getName()).log(Level.SEVERE, null, ex);
          close();
        }
     }
      return results ; 
    }
  
  
  public void close () 
  {
      try
      {
          connection.close();
      }
      catch (SQLException sqlException)
      {
          sqlException.printStackTrace();
      }
      
  }
  
}
//300316