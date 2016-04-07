package org.es.zolbareshet.utilities;

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
    public static final String TIME_ZONE_PROPERTY ="time-zone";
    //--------QUERIES------------------------------------

    public static final String CHECKING_NEW_USER_NICKNAME_REGISTRATION_QUERY="";
    public static final String CHECKING_NEW_USER_EMAIL_REGISTRATION_QUERY="";
    public static final String ADD_NEW_USER_QUERY="";
    public static final String GET_ALL_COUNTRIES_QUERY= "SELECT * FROM countries ORDER BY countriename ASC" ;
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

    //--------------DATABASE FIELDS-----------------------

    public static final String ORDERID_FIELD ="";
    public static final String CATEGORY_NAME_FIELD ="";
    public static final String COUNTRY_NAME_FIELD="countriename";
    public static final int COUNTRY_NAME_FIELD_INDEX=1;


    //--------------DATABASE TABLES------------------------

    public static final String ORDERS_TABLE ="";
    public static final String CATEGORY_TABLE ="";
    public static final String COUNTRIES_TABLE="countries";

    //-------------INDEX TABLE------------------------------

    public static final int USER_TABLE_FIRST_NAME_COLUMN = 1;

    //--------------QueryHandlers--------------------------------------


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


}
