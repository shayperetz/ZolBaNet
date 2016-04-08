package org.es.zolbareshet.utilities;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InstallationQueries{

    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/ZolBareshetDataBase";
        String dataBaseUserName = "postgres";
        String password = "password";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, dataBaseUserName, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        /*runQuery(connection, CREATE_TABLE_USERS);
        runQuery(connection, CREATE_TABLE_PHONE_NUMBER);
        runQuery(connection, CREATE_TABLE_PRODUCT_CATEGORIES);
        runQuery(connection, CREATE_TABLE_PRODUCTS);*/
        runQuery(connection, ADD_CONFIGURATION2);
     //   runQuery(connection, CREATE_TABLE_CARTS);
       // runQuery(connection, CREATE_TABLE_ORDER_CONTENT);
     //   runQuery(connection, CREATE_TABLE_CLIENT_PAYMENT);




    }
    public static void runQuery(Connection c,String s){
        try {
            PreparedStatement p =c.prepareStatement(s);
            p.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //--------INSTALLATION QUERIES------------------------

    public static final String CREATE_TABLE_CONFIG = "CREATE table config (configuration VARCHAR(20) NOT NULL ,value VARCHAR(20) NOT NULL,  PRIMARY KEY (configuration));";
    public static final String ADD_CONFIGURATION1 = "insert into config values('next_product_number',0)";
    public static final String ADD_CONFIGURATION2 = "insert into config values('next_order_number',0)";

    public static final String CREATE_TABLE_PHONE_NUMBER =  "create table Phone_Number (\n" +
            "UserName VARCHAR(20) NOT NULL,\n" +
            "prefix VARCHAR (3) NOT NULL,\n" +
            "PhoneNumber VARCHAR (10) NOT NULL,\n" +
            "PhoneType VARCHAR(20) NOT NULL ,\n" +
            "PRIMARY KEY (UserName) \n" +
            ");";

    public static final String  CREATE_TABLE_CARTS =   "   create table Carts (\n" +
            "UserName VARCHAR(20)NOT NULL,\n" +
            "ProductNumber numeric(12,0) NOT NULL,\n" +
            "Quantity Integer NOT NULL,\n" +
            "PRIMARY KEY (UserName) ,\n" +
            "FOREIGN KEY (ProductNumber ) REFERENCES Products(ProductNumber) \n" +
            ");";

    public static final String  CREATE_TABLE_USERS =   " create table Users (\n" +
            "UserName    VARCHAR(20) NOT NULL,\n" +
            "FirstName   VARCHAR(50) NOT NULL,\n" +
            "LastName    VARCHAR(50) NOT NULL,\n" +
            "Password    VARCHAR(50) NOT NULL,\n" +
            "IsActive    boolean NOT NULL,\n" +
            "country     VARCHAR(50) NOT NULL,\n" +
            "City        VARCHAR(50) NOT NULL,\n" +
            "Street      VARCHAR(50) NOT NULL,\n" +
            "HouseNumber VARCHAR(10) NOT NULL,\n" +
            "FloorNumber INTEGER NOT NULL,\n" +
            "ZipCode     INTEGER NOT NULL,\n" +
            "Email       VARCHAR(50) NOT NULL,\n" +
            "BirthDate   date not null ,  \n" +
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
            "OrderID numeric(12,0) NOT NULL,\n" +
            "DateOrder Date NOT NULL,\n" +
            "TotalPay numeric(12,0) NOT NULL,\n" +
            "UNIQUE (OrderID),\n" +
            "PRIMARY KEY (UserName ,OrderID) ,\n" +
            "FOREIGN KEY (UserName) REFERENCES Users(UserName) \n" +
            ");" ;

    public static final String CREATE_TABLE_PRODUCTS="   create table Products (\n" +
            "ProductNumber numeric(12,0) NOT NULL,\n" +
            "ProductName VARCHAR(20) NOT NULL,\n" +
            "Description Text  NOT NULL,\n" +
            "Price numeric(12,0) NOT NULL,\n" +
            "AvailableQuantity INTEGER NOT NULL,\n" +
            "IsForSale boolean NOT NULL,\n" +
            "Discount numeric(3,0) NOT NULL,\n" +
            "ProductCategory VARCHAR(20) NOT NULL,\n" +
            "Image            BYTEA       NOT NULL,\n" +
            "PRIMARY KEY (ProductNumber)\n" +
            ");";

    public static final String CREATE_TABLE_ORDER_CONTENT = "create table Order_Content (\n" +
            "ProductNumber numeric(12,0) NOT NULL,\n" +
            "OrderID numeric(12,0) NOT NULL,\n" +
            "Quantity Integer NOT NULL,\n" +
            "OrderOrCart Integer NOT NULL,\n" +
            "PRIMARY KEY (ProductNumber , OrderID) ,\n" +
            "FOREIGN KEY (ProductNumber ) REFERENCES Products(ProductNumber), \n" +
            "FOREIGN KEY (OrderID ) REFERENCES Orders(OrderID)\n" +
            ");"  ;

    public static final String CREATE_TABLE_PRODUCT_CATEGORIES =    "create table ProductCategories (\n" +
            "ProductCategory VARCHAR(20) NOT NULL,\n" +
            "Image BYTEA NOT NULL,\n" +
            "PRIMARY KEY (ProductCategory) \n" +
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