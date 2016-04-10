package org.es.zolbareshet.ServerInstallation;


import org.es.zolbareshet.entities.users.Password;
import org.es.zolbareshet.utilities.Constants;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class InstallationHelper {

    public static void buildTables(String url, String username, String password, String port) throws SQLException{
       /* String url = "jdbc:postgresql://localhost:5432/ZolBareshetDataBase";
        String dataBaseUserName = "postgres";
        String password = "password";*/
        Connection connection = null;
        url = "jdbc:postgresql://"+url+":"+port+"/ZolBareshetDataBase";
        connection = DriverManager.getConnection(url, username, password);

        //runQuery(connection, CREATE_DATABASE);
        runQuery(connection, CREATE_TABLE_USERS);
       // runQuery(connection, CREATE_TABLE_COUNTRIES);
        runQuery(connection, CREATE_TABLE_PHONE_NUMBER);
        runQuery(connection, CREATE_TABLE_ORDERS);
        runQuery(connection, CREATE_TABLE_PRODUCT_CATEGORIES);
        runQuery(connection, CREATE_TABLE_PRODUCTS);
        runQuery(connection, CREATE_TABLE_CARTS);
        runQuery(connection, CREATE_TABLE_ORDER_CONTENT);
        runQuery(connection, CREATE_TABLE_CLIENT_PAYMENT);
        //runQuery(connection, FILL_COUNTRIES);



    }

    public static void updateConfigFile(String path, String username, String password, String port) throws IOException{
        Properties prop = new Properties();
        File configFile = new File(path);
        FileInputStream inStream = new FileInputStream(configFile);
        prop.load(inStream);
        inStream.close();
        FileOutputStream outStream = new FileOutputStream(path);
        prop.setProperty(Constants.PORT_PROPERTY, port);
        prop.setProperty(Constants.USER_NAME_PROPERTY, username);
        prop.setProperty(Constants.ENCRYPTED_PASSWORD_PROPERTY, Password.encryptedPasswordMaker(password));
        prop.store(outStream, null);
        outStream.close();

    }
    public static void runQuery(Connection c,String s) throws SQLException{

            PreparedStatement p =c.prepareStatement(s);
            p.executeUpdate();

    }

    //--------INSTALLATION QUERIES------------------------

    public static final String CREATE_TABLE_CONFIG = "CREATE table config (configuration VARCHAR(20) NOT NULL ,value VARCHAR(20) NOT NULL,  PRIMARY KEY (configuration));";

    public static final String CREATE_TABLE_PHONE_NUMBER =  "create table PhoneNumbers (\n" +
            "UserName VARCHAR(20) NOT NULL,\n" +
            "prefix VARCHAR (3) NOT NULL,\n" +
            "PhoneNumber VARCHAR (10) NOT NULL,\n" +
            "PhoneType integer NOT NULL ,\n" +
            "PRIMARY KEY (UserName) \n" +
            ");";

    public static final String  CREATE_TABLE_CARTS =   "   create table Carts (\n" +
            "cartNumber serial not null,\n"+
            "UserName VARCHAR(20)NOT NULL,\n" +
            "PRIMARY KEY (UserName),\n" +
            "UNIQUE (username)\n" +
            ");";

    public static final String  CREATE_TABLE_USERS =   " create table Users (\n" +
            "UserName    VARCHAR(20) NOT NULL,\n" +
            "FirstName   VARCHAR(50) NOT NULL,\n" +
            "LastName    VARCHAR(50) NOT NULL,\n" +
            "Password    VARCHAR(50) NOT NULL,\n" +
            "IsActive    boolean NOT NULL,\n" +
            "country     VARCHAR(50) ,\n" +
            "City        VARCHAR(50) ,\n" +
            "Street      VARCHAR(50) ,\n" +
            "HouseNumber VARCHAR(10) ,\n" +
            "FloorNumber INTEGER ,\n" +
            "ZipCode     INTEGER ,\n" +
            "Email       VARCHAR(50) NOT NULL,\n" +
            "BirthDate   date ,  \n" +
            "UserType    INTEGER NOT NULL,\n" +
            "Gender      integer ,\n" +
            "UNIQUE (Email),\n" +
            "PRIMARY KEY (UserName));" ;

    public static final String CREATE_TABLE_COUNTRIES =  " create table countries (\n" +
            "countrieName VARCHAR(50) NOT NULL,\n" +
            "PRIMARY KEY (countrieName)  \n" +
            ");";

    public static final String CREATE_TABLE_ORDERS = "create table Orders (\n" +
            "UserName VARCHAR(20) NOT NULL,\n" +
            "OrderID SERIAL NOT NULL,\n" +
            "DateOrder Date NOT NULL,\n" +
            "TotalPay numeric(12,0) NOT NULL,\n" +
            "OrderID serial NOT NULL,\n" +
            "OrderDate Date NOT NULL,\n" +
            "TotalPay numeric(12,2) NOT NULL,\n" +
            "UNIQUE (OrderID),\n" +
            "PRIMARY KEY (OrderID) ,\n" +
            "FOREIGN KEY (UserName) REFERENCES Users(UserName) \n" +
            ");" ;

    public static final String CREATE_TABLE_PRODUCTS="   create table Products (\n" +

            "ProductNumber SERIAL NOT NULL,\n" +
            "ProductNumber serial NOT NULL,\n" +
            "ProductName VARCHAR(20) NOT NULL,\n" +
            "Description Text  NOT NULL,\n" +
            "Price numeric(12,2) NOT NULL,\n" +
            "AvailableQuantity INTEGER NOT NULL,\n" +
            "IsForSale boolean NOT NULL,\n" +
            "Discount numeric(5,2) NOT NULL,\n" +
            "ProductCategory VARCHAR(20) NOT NULL,\n" +
            "Image            BYTEA       NOT NULL,\n" +
            "PRIMARY KEY (ProductNumber)\n" +
            ");";

    public static final String CREATE_TABLE_ORDER_CONTENT = "create table OrderContent (\n" +
            "ProductNumber numeric(12,0) NOT NULL,\n" +
            "OrderID integer NOT NULL,\n" +
            "Quantity Integer NOT NULL,\n" +
            "OrderOrCart Integer NOT NULL,\n" +
            "payment numeric(12,2) NOT NULL,\n" +
            "PRIMARY KEY (ProductNumber , OrderID, orderorcart) ,\n" +
            "FOREIGN KEY (OrderID ) REFERENCES Orders(OrderID)\n" +
            ");"  ;

    public static final String CREATE_TABLE_PRODUCT_CATEGORIES =    "create table Categories (\n" +
            "Category VARCHAR(20) NOT NULL,\n" +
            "Image BYTEA NOT NULL,\n" +
            "PRIMARY KEY (Category) \n" +
            ");";


    public static final String CREATE_TABLE_CLIENT_PAYMENT =    "create table ClientsPayment (\n" +
            "UserName VARCHAR(20) NOT NULL,\n" +
            "UserID integer NOT NUll,\n" +
            "CardNumber  numeric(16,0) NOT NULL,\n" +
            "CardType Integer NOT NULL,\n" +
            "ExDate Date   NOT NULL,\n" +
            "PRIMARY KEY (UserName)	 \n" +
            ");" ;
}