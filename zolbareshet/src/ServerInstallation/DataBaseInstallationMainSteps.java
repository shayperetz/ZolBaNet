/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerInstallation;

import static ServerInstallation.DataBaseInstaller.tableCreator;
import java.io.IOException;
import org.es.zolbareshet.utilities.Constants;

public class DataBaseInstallationMainSteps {
  
   public static void main (String args []) throws IOException
    {
        final String DataBasePath   = "C:\\ProgramData\\ZolBareshet\\CREATE_DATABASE.sql" ;
        if ( DataBaseInstaller.RunQuery(DataBasePath ))
        {
        tableCreator(Constants.CREATE_TABLE_USERS);
        tableCreator(Constants.CREATE_TABLE_PRODUCTS);
        tableCreator(Constants.CREATE_TABLE_PHONE_NUMBER);
        tableCreator(Constants.CREATE_TABLE_COUNTRIES);
        tableCreator(Constants.CREATE_TABLE_PRODUCT_CATEGORIES);
        tableCreator(Constants.CREATE_TABLE_CLIENT_PAYMENT);
        tableCreator(Constants.CREATE_TABLE_ORDERS);
        tableCreator(Constants.CREATE_TABLE_ORDER_CONTENT);
        tableCreator(Constants.CREATE_TABLE_CARTS);
        
        
        }
    }
}

