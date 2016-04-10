package org.es.zolbareshet.utilities;

import org.es.zolbareshet.queries.Parameter;
import org.es.zolbareshet.queries.QueriesHandler;

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
    public static final String DAYS_BETWEEN_CART_DISPOSER_RUNS_PROPERTY = "days-between-cart-disposer";
    public static final String CART_EXPIRES_AFTER_PROPERTY = "days-to-hold-open-carts";
    
    //--------QUERIES------------------------------------

    public static final String CHECKING_NEW_USER_NICKNAME_REGISTRATION_QUERY="";
    public static final String CHECKING_NEW_USER_EMAIL_REGISTRATION_QUERY="";
    public static final String ADD_NEW_USER_QUERY="";
    public static final String GET_ALL_COUNTRIES_QUERY= "SELECT * FROM " + Constants.TABLE_COUNTRIES +" ORDER BY " + Constants.TABLE_COUNTRIES_COUNTRY_NAME + " ASC" ;
    public static final String DELETE_USER_CART_QUERY ="";
    public static final String GET_ALL_USERS_WITH_CARTS_QUERY = "";
    public static final String GET_ALL_SUPER_USERS_QUERY="SELECT u.username, p.phonenumber FROM users u,phones p WHERE u.username=p.username AND" +
                                                              " (p.phonenumber = (SELECT MIN(p2.phoneNumber) FROM phones p2 WHERE u.username=p2.username)) ORDER BY username";
    public static final String GET_SUPERUSER_FIELDS = "SELECT username, firstname, lastname, password, email, role FROM users WHERE username=?";
    public static final String GET_ALL_USER_PHONES = "SELECT perfix, phonenumber, type FROM phones WHERE username=?";
    public static final String GET_ALL_CATEGORIES_QUERY = "SELECT * FROM categories";
    public static final String GET_ALL_CATEGORIES_NAMES_QUERY = "SELECT categoryname FROM categories";
    public static final String ADD_CATEGORY_QUERY ="insert into categories values(?,?)";
    public static final String GET_CATEGORY_IMAGE_QUERY = "SELECT image FROM categories WHERE categoryname=?";
    public static final String GET_PRODUCT_IMAGE_QUERY = "SELECT image FROM products WHERE productname=?";

    public static final String ADD_PRODUCT_QUERY ="INSERT INTO products2 values(?,?,?,?,?,?,?,?)";

    //--------------PAGES NAMES---------------------------
    public static final String REGISTRATION_PAGE="/accounting/registration";
    public static final String MANAGEMENT_PAGE="/management/management";
    public static final String FORBIDDEN_PAGE ="forbiddenPage";
    public static final String MAIN_PAGE = "main";
    public static final String NEW_SUPER_PAGE = "/management/newSuperuser";

    //--------------ROLES---------------------------------------------
    public static final int ADMINISTRATOR = 1;
    public static final int STOREKEEPER = 2;
    public static final int CUSTOMER = 3;

    //-----------PHONE TYPES---------------------------------------
    public static final int HOME = 1;
    public static final int MOBILE = 2;
    public static final int WORK = 3;

    //--------------------GENDER------------------------------------
    public static final int MALE = 1;
    public static final int FEMALE= 2;

    //--------------------ORDER/CART-----------------------------
    public static final int ORDER = 1;
    public static final int CART = 2;


    //--------------DATABASE TABLES-------------------------------
    public static final String TABLE_CATEGORIES ="Categories";
    public static final String TABLE_CARTS ="Carts";
    public static final String TABLE_CLIENTS_PAYMENT = "ClientsPayment" ;
    public static final String TABLE_COUNTRIES="countries";
    public static final String TABLE_ORDERS_CONTENT ="OrderContent";
    public static final String TABLE_ORDERS ="Orders";
    public static final String TABLE_PRODUCTS = "Products" ;
    public static final String TABLE_PHONES = "PhoneNumbers" ;
    public static final String TABLE_USER_NAME = "Users" ;


    //--------------DATABASE USER FIELDS--------------------------
    public static final String TABLE_USER_NAME_USER_NAME = "UserNmae" ;
    public static final String TABLE_USER_NAME_FIRST_NAME = "FirstName";
    public static final String TABLE_USER_NAME_LAST_NAME = "LastName";
    public static final String TABLE_USER_NAME_PASSWORD = "Password";
    public static final String TABLE_USER_NAME_IS_ACTIVE = "IsActive";
    public static final String TABLE_USER_NAME_COUNTRY = "Country" ;
    public static final String TABLE_USER_NAME_CITY = "City" ;
    public static final String TABLE_USER_NAME_STREET = "Street" ;
    public static final String TABLE_USER_NAME_HOUSE_NUMBER = "HouseNumber" ;
    public static final String TABLE_USER_NAME_FLOOR_NUMBER = "FloorNumber" ;
    public static final String TABLE_USER_NAME_ZIP_CODE = "ZipCode" ;
    public static final String TABLE_USER_NAME_EMAIL = "Email" ;
    public static final String TABLE_USER_NAME_BIRTH_DATE = "Birth_Date";
    public static final String TABLE_USER_NAME_USER_TYPE = "User_Type" ;
    public static final String TABLE_USER_NAME_GENDER = "Gender" ;
    //-------------------INDEXES---------------------------------
    public static final int INDEX_USER_NAME_TABLE_USERS    = 1  ;
    public static final int INDEX_FIRST_NAME_TABLE_USERS   = 2  ;
    public static final int INDEX_LAST_NAME_TABLE_USERS    = 3  ;
    public static final int INDEX_PASSWORD_TABLE_USERS     = 4  ;
    public static final int INDEX_IS_ACTIVE_TABLE_USERS    = 5  ;
    public static final int INDEX_COUNTRY_TABLE_USERS      = 6  ;
    public static final int INDEX_CITY_TABLE_USERS         = 7  ;
    public static final int INDEX_STREET_TABLE_USERS       = 8  ;
    public static final int INDEX_HOUSE_NUMBER_TABLE_USERS = 9  ;
    public static final int INDEX_FLOOR_NUMBER_TABLE_USERS = 10 ;
    public static final int INDEX_ZIP_CODE_TABLE_USERS     = 11 ;
    public static final int INDEX_EMAIL_TABLE_USERS        = 12 ;
    public static final int INDEX_BIRTH_DATE_TABLE_USERS   = 13 ;
    public static final int INDEX_USER_TYPE_TABLE_USERS    = 14 ;
    public static final int INDEX_GENDER_TABLE_USERS       = 15 ;
    //--------------------TYPES-----------------------------------
    public static final Parameter.TYPE TYPE_USER_NAME_TABLE_USERS    = Parameter.TYPE.STRING ;
    public static final Parameter.TYPE TYPE_FIRST_NAME_TABLE_USERS   = Parameter.TYPE.STRING  ;
    public static final Parameter.TYPE TYPE_LAST_NAME_TABLE_USERS    = Parameter.TYPE.STRING  ;
    public static final Parameter.TYPE TYPE_PASSWORD_TABLE_USERS     = Parameter.TYPE.STRING  ;
    public static final Parameter.TYPE TYPE_IS_ACTIVE_TABLE_USERS    = Parameter.TYPE.BOOLEAN  ;
    public static final Parameter.TYPE TYPE_COUNTRY_TABLE_USERS      = Parameter.TYPE.STRING  ;
    public static final Parameter.TYPE TYPE_CITY_TABLE_USERS         = Parameter.TYPE.STRING  ;
    public static final Parameter.TYPE TYPE_STREET_TABLE_USERS       = Parameter.TYPE.STRING  ;
    public static final Parameter.TYPE TYPE_HOUSE_NUMBER_TABLE_USERS = Parameter.TYPE.STRING  ;
    public static final Parameter.TYPE TYPE_FLOOR_NUMBER_TABLE_USERS = Parameter.TYPE.INT ;
    public static final Parameter.TYPE TYPE_ZIP_CODE_TABLE_USERS     = Parameter.TYPE.INT ;
    public static final Parameter.TYPE TYPE_EMAIL_TABLE_USERS        = Parameter.TYPE.STRING ;
    public static final Parameter.TYPE TYPE_BIRTH_DATE_TABLE_USERS   = Parameter.TYPE.DATE ;
    public static final Parameter.TYPE TYPE_USER_TYPE_TABLE_USERS    = Parameter.TYPE.INT ;
    public static final Parameter.TYPE TYPE_GENDER_TABLE_USERS       = Parameter.TYPE.INT ;
    
    //--------------DATABASE PHONE NUMBER FIELDS------------------
    public static final String TABLE_PHONES_USER_NAME = "username";
    public static final String TABLE_PHONES_PREFIX  = "prefix" ;
    public static final String TABLE_PHONES_PHONE_NUMBER = "PhoneNumber" ;
    public static final String TABLE_PHONESPHONE_TYPE = "PhoneType" ;
    //-------------------------INDEXES---------------------------
    public static final int INDEX_USER_NAME_TABLE_PHONES    = 1 ;
    public static final int INDEX_PREFIX_TABLE_PHONES       = 2 ;
    public static final int INDEX_PHONE_NUMBER_TABLE_PHONES = 3 ;
    public static final int INDEX_PHONE_TYPE_TABLE_PHONES   = 4 ;
    //--------------------TYPES-----------------------------------
    public static final Parameter.TYPE TYPE_USER_NAME_TABLE_PHONES    = Parameter.TYPE.STRING ;
    public static final Parameter.TYPE TYPE_PREFIX_TABLE_PHONES       = Parameter.TYPE.STRING ;
    public static final Parameter.TYPE TYPE_PHONE_NUMBER_TABLE_PHONES = Parameter.TYPE.STRING ;
    public static final Parameter.TYPE TYPE_PHONE_TYPE_TABLE_PHONES   = Parameter.TYPE.INT ;

    //--------------DATABASE PRODUCT FIELDS-------------------------
    public static final String TABLE_PRODUCTS_PRODUCT_NUMBER = "ProductNumber" ;
    public static final String TABLE_PRODUCTS_PRODUCT_NAME = "ProductName" ;
    public static final String TABLE_PRODUCTS_PRODUCT_DESCRIPTION = "Description" ;
    public static final String TABLE_PRODUCTS_PRICE ="Price" ;
    public static final String TABLE_PRODUCTS_AVAILABLE_QUANTITY = "AvailableQuantity";
    public static final String TABLE_PRODUCTS_IS_FOR_SALE = "IsForSale" ;
    public static final String TABLE_PRODUCTS_DISCOUNT = "Discount" ;
    public static final String TABLE_PRODUCTS_PRODUCT_CATEGORY = "ProductCategory" ;
    public static final String TABLE_PRODUCTS_IMAGE = "Image";
    //----------------INDEXES--------------------------------------
    public static final int INDEX_PRODUCT_NUMBER_TABLE_PRODUCTS        = 1 ;
    public static final int INDEX_RODUCT_NAME_TABLE_PRODUCTS           = 2 ;
    public static final int INDEX_PRODUCT_DESCRIPTION_TABLE_PRODUCTS   = 3 ;
    public static final int INDEX_PRICE_TABLE_PRODUCTS                 = 4 ;
    public static final int INDEX_AVAILABLE_QUANTITY_TABLE_PRODUCTS    = 5 ;
    public static final int INDEX_IS_FOR_SALE_TABLE_PRODUCTS           = 6 ;
    public static final int INDEX_DISCOUNT_TABLE_PRODUCTS              = 7 ;
    public static final int INDEX_PRODUCT_CATEGORY_TABLE_PRODUCTS      = 8 ;
    public static final int INDEX_PRODUCT_IMAGE_TABLE_PRODUCTS         = 9 ;
    //--------------------TYPES-----------------------------------
    public static final Parameter.TYPE TYPE_PRODUCT_NUMBER_TABLE_PRODUCTS        = Parameter.TYPE.INT ;
    public static final Parameter.TYPE TYPE_RODUCT_NAME_TABLE_PRODUCTS           = Parameter.TYPE.STRING ;
    public static final Parameter.TYPE TYPE_PRODUCT_DESCRIPTION_TABLE_PRODUCTS   = Parameter.TYPE.STRING ;
    public static final Parameter.TYPE TYPE_PRICE_TABLE_PRODUCTS                 = Parameter.TYPE.FLOAT ;
    public static final Parameter.TYPE TYPE_AVAILABLE_QUANTITY_TABLE_PRODUCTS    = Parameter.TYPE.INT ;
    public static final Parameter.TYPE TYPE_IS_FOR_SALE_TABLE_PRODUCTS           = Parameter.TYPE.BOOLEAN ;
    public static final Parameter.TYPE TYPE_DISCOUNT_TABLE_PRODUCTS              = Parameter.TYPE.FLOAT ;
    public static final Parameter.TYPE TYPE_PRODUCT_CATEGORY_TABLE_PRODUCTS      = Parameter.TYPE.STRING ; ;
    public static final Parameter.TYPE TYPE_PRODUCT_IMAGE_TABLE_PRODUCTS         = Parameter.TYPE.BYTES;

    //--------------DATABASE ORDERS FIELDS------------------------
    public static final String TABLE_ORDERS_USER_NAME ="username";
    public static final String TABLE_ORDERS_ORDER_ID = "OrderID" ;
    public static final String TABLE_ORDERS_ORDER_DATE = "OrderDate" ;
    public static final String TABLE_ORDERS_TOTAL_PAY = "TotalPay";
    //--------------------------------INDEXES-----------------------
    public static final int INDEX_USER_NAME_TABLE_ORDERS  = 1 ;
    public static final int INDEX_ORDER_ID_TABLE_ORDERS   = 2 ;
    public static final int INDEX_ORDER_DATE_TABLE_ORDERS = 3 ;
    public static final int INDEX_TOTAL_PAY_TABLE_ORDERS  = 4 ;
    //--------------------TYPES-----------------------------------
    public static final Parameter.TYPE TYPE_USER_NAME_TABLE_ORDERS    = Parameter.TYPE.STRING ;
    public static final Parameter.TYPE TYPE_ORDER_ID_TABLE_ORDERS   = Parameter.TYPE.INT ;
    public static final Parameter.TYPE TYPE_ORDER_DATE_TABLE_ORDERS = Parameter.TYPE.DATE ;
    public static final Parameter.TYPE TYPE_TOTAL_PAY_TABLE_ORDERS  = Parameter.TYPE.FLOAT ;

    //--------------DATABASE ORDER CONTENT FIELDS-----------------
    public static final String TABLE_ORDERS_CONTENT_ORDER_ID="orderID";
    public static final String TABLE_ORDERS_CONTENT_QUANTITY = "Quntity" ;
    public static final String TABLE_ORDERS_CONTENT_ORDER_OR_CART = "OrderOrCart" ;
    public static final String TABLE_ORDERS_CONTENT_PRODUCT_NUMBER="productNumber";
    public static final String TABLE_ORDERS_CONTENT_PAYMENT="payment";
    //-----------------------------INDEXES-----------------
    public static final int INDEX_RODUCT_NUMBER_TABLE_ORDERS_CONTENT  = 1 ;
    public static final int INDEX_ORDER_ID_TABLE_ORDERS_CONTENT       = 2 ;
    public static final int INDEX_QUANTITY_TABLE_ORDERS_CONTENT       = 3 ;
    public static final int INDEX_ORDER_OR_CART_TABLE_ORDERS = 4 ;
    public static final int INDEX_PAYMENT_TABLE_ORDERS = 5 ;
    //--------------------TYPES-----------------------------------
    public static final Parameter.TYPE TYPE_RODUCT_NUMBER_TABLE_ORDERS_CONTENT  = Parameter.TYPE.INT ;
    public static final Parameter.TYPE TYPE_ORDER_ID_TABLE_ORDERS_CONTENT       = Parameter.TYPE.INT;
    public static final Parameter.TYPE TYPE_QUANTITY_TABLE_ORDERS_CONTENT       = Parameter.TYPE.INT ;
    public static final Parameter.TYPE TYPE_ORDER_OR_CART_TABLE_ORDERS          = Parameter.TYPE.INT ;
    public static final Parameter.TYPE TYPE_PAYMENT_TABLE_ORDERS          = Parameter.TYPE.FLOAT ;

    //--------------DATABASE COUNTRIES FIELDS---------------------
    public static final String TABLE_COUNTRIES_COUNTRY_NAME="CountrieName";
    //------------------------------INDEXES-------------------------
    public static final int INDEX_COUNTRY_NAME_TABLE_COUNTRIES   = 1 ;
    //--------------------TYPES-----------------------------------
    public static final Parameter.TYPE TYPE_COUNTRY_NAME_TABLE_COUNTRIES   = Parameter.TYPE.STRING;

    //--------------DATABASE CLIENT PAYMENTS FIELDS---------------
    public static final String TABLE_CLIENTS_PAYMENT_USER_NAME="userName";
    public static final String TABLE_CLIENTS_PAYMENT_USER_ID = "UserID" ;
    public static final String TABLE_CLIENTS_PAYMENT_CARD_NUMBER = "CardNumber" ;
    public static final String TABLE_CLIENTS_PAYMENT_CARD_TYPE = "CardType"  ;
    public static final String TABLE_CLIENTS_PAYMENT_EX_DADE = "ExDate"  ;
    //------------------------------INDEXES-----------------------
    public static final int INDEX_USER_NAME_TABLE_CLIENT_PAYMENT     = 1 ;
    public static final int INDEX_USER_ID_TABLE_CLIENT_PAYMENT       = 2 ;
    public static final int INDEX_CARD_NUMBER_TABLE_CLIENT_PAYMENT   = 3 ;
    public static final int INDEX_CARD_TYPE_TABLE_CLIENT_PAYMENT     = 4 ;
    public static final int INDEX_EX_DATE_TABLE_CLIENT_PAYMENT       = 5 ;
    //--------------------TYPES-----------------------------------
    public static final Parameter.TYPE TYPE_USER_NAME_TABLE_CLIENT_PAYMENT     = Parameter.TYPE.STRING ;
    public static final Parameter.TYPE TYPE_USER_ID_TABLE_CLIENT_PAYMENT       = Parameter.TYPE.INT ;
    public static final Parameter.TYPE TYPE_CARD_NUMBER_TABLE_CLIENT_PAYMENT   = Parameter.TYPE.FLOAT ;
    public static final Parameter.TYPE TYPE_CARD_TYPE_TABLE_CLIENT_PAYMENT     = Parameter.TYPE.INT ;
    public static final Parameter.TYPE TYPE_EX_DATE_TABLE_CLIENT_PAYMENT       = Parameter.TYPE.DATE ;

    //--------------DATABASE CART FIELDS--------------------------
    public static final String TABLE_CARTS_CART_NUMBER="cartNumber";
    public static final String TABLE_CARTS_USER_NAME="userName";
    //---------------------INDEXES---------------------------------
    public static final int INDEX_USER_NAME_TABLE_CARTS      = 2 ;
    public static final int INDEX_CART_NUMBER_TABLE_CARTS      = 1 ;
    //--------------------TYPES-----------------------------------
    public static final Parameter.TYPE TYPE_USER_NAME_TABLE_CARTS      = Parameter.TYPE.STRING ;
    public static final Parameter.TYPE TYPE_CART_NUMBER_TABLE_CARTS      = Parameter.TYPE.INT ;

    //--------------DATABASE CATEGORY FIELDS----------------------
    public static final String TABLE_CATEGORIES_CATEGORY = "Category" ;
    public static final String TABLE_CATEGORIES_IMAGE = "image" ;
    //-----------------------------INDEXES-------------------------
    public static final int INDEX_CATEGORIES_TABLE_CATEGORY         = 1 ;
    public static final int INDEX_IMAGE_TABLE_CATEGORY   = 2 ;
    //--------------------TYPES-----------------------------------
    public static final Parameter.TYPE TYPE_CATEGORIES_TABLE_CATEGORY         = Parameter.TYPE.STRING ;
    public static final Parameter.TYPE TYPE_IMAGE_TABLE_CATEGORY  = Parameter.TYPE.BYTES;














}
