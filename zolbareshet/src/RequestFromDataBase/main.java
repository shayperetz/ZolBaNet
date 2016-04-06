/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RequestFromDataBase;

import ProjectEntities.Address;
import ProjectEntities.PhoneNumber;
import ProjectEntities.User;
import ProjectEntities.date;
import java.io.IOException;
import java.util.Date;

/**
 *
 * @author peretzs
 */
public class main {
    public static void main (String args []) throws IOException
    {
        String userName ="shay4040" ; 
       /* 
          System.out.println(" IS USER EXIST : " +  DataUsers.isUserExist(userName));
          
         String       UserName    = "David123456"  ;     
	 String       FirstName   =  "David"  ;  
	 String       LastName    = "Bowie"  ; 
	 String       Password    = "IamTheKing123"  ;
	 boolean      IsActive    = true  ;
         PhoneNumber  Numbers     = new PhoneNumber (0527777777,0,0,0) ;
         Address      address     = new Address ("israel" , "Hadera" , "BenTzvi" , "12", 1344555)  ;
	 String       Email       = " david@walla.co.il"  ;
	 date         BirthDate   = new date(22,12,1999);
	 int          UserType    =  1  ;
	 int          Gender      =  1  ; 
         User test = new User (UserName,FirstName,LastName,Password,IsActive,Numbers,address,Email,BirthDate,UserType,Gender); 
         UserQueries n = new UserQueries () ;
         n.addUser(test) ;
         */
         // testing getUserDetails 
         if ( DataUsers.getUserDetails(userName) == null ) 
         {
             System.out.println("User Not Exist");
         }
         else System.out.println("Done ");
         System.out.println("Done ");
         System.out.println("Done ");
         System.out.println("Done ");
         System.out.println("Done ");
    }
}

//300316