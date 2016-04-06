package org.es.zolbareshet.utilities;

/**
 * Created by eilons on 3/7/2016.
 */
public class Constants {

    //------------config file--------------------------

    public static final String PROPERTY_FILE_NAME = "config.properties";
    public static final String  LOG_FILE_NAME_PROPERTY = "log-file-name";
    public static final String DEBUGGING_LEVEL_PROPERTY ="debugging-level";
    public static final String USER_NAME_PROPERTY ="user-name";
    public static final String ENCRYPTED_PASSWORD_PROPERTY ="encrypted-password";
    public static final String PORT_PROPERTY = "port";

    //--------QUERIES------------------------------------

    public static final String CHECKING_NEW_USER_NICKNAME_REGISTRATION_QUERY="";
    public static final String CHECKING_NEW_USER_EMAIL_REGISTRATION_QUERY="";
    public static final String ADD_NEW_USER_QUERY="";
    public static final String GET_ALL_FROM_TABLE_QUERY= "SELECT *FROM ? ORDER BY ? ASC" ;
    public static final String DELETE_ORDER_QUERY ="";
    //--------INSTALLATION QUERIES------------------------
    public static final String CREATE_TABLE_PHONE_NUMBER =  "create table Phone_Number (\n" +
                                                            "UserName VARCHAR(20) NOT NULL,\n" +
                                                            "prefix VARCHAR (3) NOT NULL,\n" +
                                                            "PhoneNumber VARCHAR (10) NOT NULL,\n" +
                                                            "PhoneType VARCHAR(20) NOT NULL ,\n" +
                                                            "PRIMARY KEY (UserName) \n" +
                                                            ");";
    
     public static final String  CREATE_TABLE_CARTS =   "   create table Carts (\n" +
                                                        "   UserName VARCHAR(20)NOT NULL,\n" +
                                                        "   ProductNumber numeric(12,0) NOT NULL,\n" +
                                                        "   Quantity Integer NOT NULL,\n" +
                                                        "   PRIMARY KEY (UserName) ,\n" +
                                                        "   FOREIGN KEY (ProductNumber ) REFERENCES Products(ProductNumber) \n" +
                                                        "   );";
    
     public static final String  CREATE_TABLE_USERS =   " create table Users (\n" + 
                                                        " UserName    VARCHAR(20) NOT NULL,\n" +
                                                        " FirstName   VARCHAR(50) NOT NULL,\n" +
                                                        " LastName    VARCHAR(50) NOT NULL,\n" +
                                                        " Password    VARCHAR(50) NOT NULL,\n" +
                                                        " IsActive    boolean NOT NULL,\n" +
                                                        " country     VARCHAR(50) NOT NULL,\n" +
                                                        " City        VARCHAR(50) NOT NULL,\n" +
                                                        " Street      VARCHAR(50) NOT NULL,\n" +
                                                        " HouseNumber VARCHAR(10) NOT NULL,\n" +
                                                        " FloorNumber INTEGER NOT NULL,\n" +
                                                        " ZipCode     INTEGER NOT NULL,\n" +
                                                        " Email       VARCHAR(50) NOT NULL,\n" +
                                                        " BirthDate   date not null ,  \n" +
                                                        " UserType    INTEGER NOT NULL,\n" +
                                                        " Gender      integer ,\n" +
                                                        " UNIQUE (Email),\n" +
                                                        " PRIMARY KEY (UserName));" ;
     
   public static final String CREATE_TABLE_COUNTRIES =  " create table countries (\n" +
                                                        " countrieName VARCHAR(50) NOT NULL,\n" +
                                                        " PRIMARY KEY (countrieName)  \n" +
                                                        " );";
  
   public static final String CREATE_TABLE_ORDERS = "create table Orders (\n" +
                                                    "UserName VARCHAR(20) NOT NULL,\n" +
                                                    "ProductNumber numeric(12,0) NOT NULL,\n" +
                                                    "OrderID numeric(12,0) NOT NULL,\n" +
                                                    "Quantity Integer NOT NULL,\n" +
                                                    "DateOrder Date NOT NULL,\n" +
                                                    "TimeOrder Time NOT NULL,\n" +
                                                    "TotalPay INTEGER NOT NULL,\n" +
                                                    "UNIQUE (OrderID),\n" +
                                                    "PRIMARY KEY (UserName ,ProductNumber , OrderID) ,\n" +
                                                    "FOREIGN KEY (UserName ) REFERENCES Users(UserName) ,\n" +
                                                    "FOREIGN KEY (ProductNumber ) REFERENCES Products(ProductNumber) \n" +
                                                    ");" ; 
   
   public static final String CREATE_TABLE_PRODUCTS="   create table Products (\n" +
                                                    "	ProductNumber numeric(12,0) NOT NULL,\n" +
                                                    "	ProductName numeric(12,0) NOT NULL,\n" +
                                                    "	Description Text  NOT NULL,\n" +
                                                    "	Price numeric(12,0) NOT NULL,\n" +
                                                    "	AvailableQuantity numeric(12,0) NOT NULL,\n" +
                                                    "	IsForSale boolean NOT NULL,\n" +
                                                    "	Discount numeric(3,0) NOT NULL,\n" +
                                                    "   ProductCategory VARCHAR(20) NOT NULL,\n" +
                                                    "	PRIMARY KEY (ProductNumber)\n" +
                                                    "	);";
           
    public static final String CREATE_TABLE_ORDER_CONTENT = "create table Order_Content (\n" +
                                                            "ProductNumber numeric(12,0) NOT NULL,\n" +
                                                            "OrderID numeric(12,0) NOT NULL,\n" +
                                                            "Quantity Integer NOT NULL,\n" +
                                                            "PRIMARY KEY (ProductNumber , OrderID) ,\n" +
                                                            "FOREIGN KEY (ProductNumber ) REFERENCES Products(ProductNumber), \n" +
                                                            "FOREIGN KEY (OrderID ) REFERENCES Orders(OrderID)\n" +
                                                            ");"  ; 

    public static final String CREATE_TABLE_PRODUCT_CATEGORIES =    "create table ProductCategories (\n" +
                                                                    "ProductCategory VARCHAR(20) NOT NULL,\n" +
                                                                    "PRIMARY KEY (ProductCategory) \n" +
                                                                    ");"; 
    
    
    public static final String CREATE_TABLE_CLIENT_PAYMENT =    "create table ClientsPayment (\n" +
                                                                "UserName VARCHAR(20) NOT NULL,\n" +
                                                                "CardNumber  numeric(16,0) NOT NULL,\n" +
                                                                "CardType Integer NOT NULL,\n" +
                                                                "ExDate Date   NOT NULL,\n" +
                                                                "PRIMARY KEY (UserName)	 \n" +
                                                                ");" ; 
    //--------------DATABASE FIELDS-------------------------------
    //--------------DATABASE USER FIELDS--------------------------
    public static final String USER_NAME = "User_Nmae" ; 
    public static final String FIRST_NAME = "First_Name";
    public static final String LAST_NAME = "Last_Name";
    public static final String PASSWORD = "Password";
    public static final String IS_ACTIVE = "Is_Active";
    public static final String COUNTRY = "Country" ; 
    public static final String CITY = "City" ; 
    public static final String STREET = "Street" ; 
    public static final String HOUSE_NUMBER = "House_Number" ; 
    public static final String FLOOR_NUMBER = "Floor_Number" ; 
    public static final String ZIP_CODE = "ZipCode" ; 
    public static final String EMAIL = "Email" ; 
    public static final String BIRTH_DATE = "Birth_Date";
    public static final String USER_TYPE = "User_Type" ; 
    public static final String GENDER = "Gender" ; 
    //--------------DATABASE PHONE NUMBER FIELDS------------------
    public static final String PREFIX  = "prefix" ; 
    public static final String PHONE_NUMBER = "Phone_Number" ; 
    public static final String PHONE_TYPE = "Phone_Type" ;
    //--------------DATABASE PRODUCT FIELDS-------------------------
    public static final String PRODUCT_NUMBER = "Product_Number" ; 
    public static final String PRODUCT_NAME = "Product_Name" ; 
    public static final String PRODUCT_DESCRIPTION = "Product_Description" ; 
    public static final String PRICE ="Price" ; 
    public static final String AVAILABLE_QUANTITY = "Available_Quantity";
    public static final String IS_FOR_SALE = "Is_For_Sale" ; 
    public static final String DISCOUNT = "Discount" ; 
    public static final String PRODUCT_CATEGORY = "ProductCategory" ;
    //--------------DATABASE ORDERS FIELDS------------------------
    public static final String ORDER_ID = "Order_ID" ; 
    public static final String ORDER_DATE = "Order_Date" ; 
    public static final String ORDER_TIME = "Order_Time" ; 
    public static final String TOTAL_PAY = "Total_Pay";
    //--------------DATABASE ORDER CONTENT FIELDS-----------------
    public static final String QUANTITY = "Quntity" ;
    //--------------DATABASE COUNTRIES FIELDS---------------------
    public static final String COUNTRY_NAME="Countrie_Name";
    //--------------DATABASE CLIENT PAYMENTS FIELDS---------------
    public static final String USER_ID = "User_ID" ; 
    public static final String CARD_NUMBER = "Card_Number" ; 
    public static final String CARD_TYPE = "Card_Type"  ;
    public static final String EX_DADE = "Ex_Date"  ;
    //--------------DATABASE CART FIELDS--------------------------
    //--------------DATABASE CATEGORY FIELDS-----------------()-----
    public static final String CATEGORY = "Category" ;
    //--------------DATABASE TABLES-------------------------------
    public static final String tbl_CATEGORY ="Category";
    public static final String tbl_CARTS ="Carts";
    public static final String tbl_CLIENT_PAYMENT = "Client_Payment" ; 
    public static final String tbl_COUNTRIES="countries";
    public static final String tbl_ORDERS_CONTENT ="Order_Content";
    public static final String tbl_ORDERS_TABLE ="Orders";
    public static final String tbl_PRODUCTS = "Products" ; 
    public static final String tbl_PHONE_NUMBER = "Phone_Number" ;
    public static final String tbl_USER_NAME = "Users" ; 
    //--------------PAGES NAMES---------------------------
    public static final String REGISTRATION_PAGE="accounting/registration";
    public static final String HOME_PAGE="result";
    public static final String MANAGEMENT_PAGE="management/management";
    //--------------orders--------------------------------
    public static final long ORDER_EXPIRE_AFTER = 1000*60*60*24*14; //two weeks
    //-------------INDEX TABLE------------------------------
    //-------------INDEX USER TABLE-------------------------
    public static final int INDEX_USER_NAME_tbl_USERS    = 1  ; 
    public static final int INDEX_FIRST_NAME_tbl_USERS   = 2  ;
    public static final int INDEX_LAST_NAME_tbl_USERS    = 3  ;
    public static final int INDEX_PASSWORD_tbl_USERS     = 4  ;
    public static final int INDEX_IS_ACTIVE_tbl_USERS    = 5  ;
    public static final int INDEX_COUNTRY_tbl_USERS      = 6  ; 
    public static final int INDEX_CITY_tbl_USERS         = 7  ; 
    public static final int INDEX_STREET_tbl_USERS       = 8  ; 
    public static final int INDEX_HOUSE_NUMBER_tbl_USERS = 9  ; 
    public static final int INDEX_FLOOR_NUMBER_tbl_USERS = 10 ; 
    public static final int INDEX_ZIP_CODE_tbl_USERS     = 11 ; 
    public static final int INDEX_EMAIL_tbl_USERS        = 12 ; 
    public static final int INDEX_BIRTH_DATE_tbl_USERS   = 13 ;
    public static final int INDEX_USER_TYPE_tbl_USERS    = 14 ; 
    public static final int INDEX_GENDER_tbl_USERS       = 15 ;
    //-------------INDEX PHONE TABLE------------------------
    public static final int INDEX_USER_NAME_tbl_PHONES    = 1 ;
    public static final int INDEX_PREFIX_tbl_PHONES       = 2 ; 
    public static final int INDEX_PHONE_NUMBER_tbl_PHONES = 3 ; 
    public static final int INDEX_PHONE_TYPE_tbl_PHONES   = 4 ;
    //-------------INDEX RODUCT TABLE-------------------------
    public static final int INDEX_PRODUCT_NUMBER_tbl_PRODUCTS        = 1 ; 
    public static final int INDEX_RODUCT_NAME_tbl_PRODUCTS           = 2 ; 
    public static final int INDEX_PRODUCT_DESCRIPTION_tbl_PRODUCTS   = 3 ; 
    public static final int INDEX_PRICE_tbl_PRODUCTS                 = 4 ; 
    public static final int INDEX_AVAILABLE_QUANTITY_tbl_PRODUCTS    = 5 ;
    public static final int INDEX_IS_FOR_SALE_tbl_PRODUCTS           = 6 ; 
    public static final int INDEX_DISCOUNT_tbl_PRODUCTS              = 7 ;
    public static final int INDEX_PRODUCT_CATEGORY_tbl_PRODUCTS      = 8 ;
    //-------------INDEX ORDERS TABLE------------------------
    public static final int INDEX_ORDER_ID_tbl_ORDERS   = 1 ; 
    public static final int INDEX_ORDER_DATE_tbl_ORDERS = 2 ; 
    public static final int INDEX_ORDER_TIME_tbl_ORDERS = 3 ; 
    public static final int INDEX_TOTAL_PAY_tbl_ORDERS  = 4 ;
    //-------------INDEX ORDERS CONTENT TABLE-----------------
    public static final int INDEX_USER_NAME_tbl_ORDERS_CONTENT      = 1 ;
    public static final int INDEX_RODUCT_NUMBER_tbl_ORDERS_CONTENT  = 2 ; 
    public static final int INDEX_ORDER_ID_tbl_ORDERS_CONTENT       = 3 ;
    public static final int INDEX_QUANTITY_tbl_ORDERS_CONTENT       = 4 ;
     //-------------INDEX COUNTRIES TABLE-----------------------
     public static final int INDEX_COUNTRY_NAME_tbl_COUNTRIES       = 1 ;
     //-------------INDEX CLIENT PAYMENTS TABLE-----------------
     public static final int INDEX_USER_NAME_tbl_CLIENT_PAYMENT     = 1 ;
     public static final int INDEX_USER_ID_tbl_CLIENT_PAYMENT       = 2 ;
     public static final int INDEX_CARD_NUMBER_tbl_CLIENT_PAYMENT   = 3 ;
     public static final int INDEX_CARD_TYPE_tbl_CLIENT_PAYMENT     = 4 ;
     public static final int INDEX_EX_DATE_tbl_CLIENT_PAYMENT       = 5 ;
     //-------------INDEX CARTS TABLE--------------------------
     public static final int INDEX_USER_NAME_tbl_CARTS      = 1 ;
     public static final int INDEX_RODUCT_NUMBER_tbl_CARTS  = 2 ;
     public static final int INDEX_QUANTITY_tbl_CARTS       = 3 ;
    //--------------INDEX CATEGORY TABLE----------------------
    public static final int INDEX_CATEGORY_tbl_CATEGORY     = 1 ;
     
     
}
