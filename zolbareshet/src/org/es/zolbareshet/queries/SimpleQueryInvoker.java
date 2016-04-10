package org.es.zolbareshet.queries;

import org.es.zolbareshet.entities.users.UserBean;
import org.es.zolbareshet.utilities.Constants;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;


public class  SimpleQueryInvoker {



    public static ArrayList<QueriesHandler.ResultLine> getAllUsersWithCarts() { //return (username,cartCreationDate) pairs
        return QueriesHandler.qHandler(Constants.GET_ALL_USERS_WITH_CARTS_QUERY, null, new Parameter.TYPE[]{Parameter.TYPE.STRING, Parameter.TYPE.LONG});
    }

    public static void discaradCart(String username) {
        QueriesHandler.updateQuery(Constants.DELETE_USER_CART_QUERY, new Parameter[]{new Parameter(username, 1, Parameter.TYPE.STRING)});
    }

    public static ArrayList<QueriesHandler.ResultLine> getAllCountries() {
        return QueriesHandler.qHandler(Constants.GET_ALL_COUNTRIES_QUERY, null, new Parameter.TYPE[]{Parameter.TYPE.STRING});
    }

    public static boolean IsSuperUser(String username) {
        return true;
    }

    public static ArrayList<QueriesHandler.ResultLine> getAllSuperUsers() {
        return QueriesHandler.qHandler(Constants.GET_ALL_SUPER_USERS_QUERY, null, new Parameter.TYPE[]{Parameter.TYPE.STRING, Parameter.TYPE.STRING});//return (username,phonenumber) pairs
    }

    public static ArrayList<QueriesHandler.ResultLine> getAllCategories() {
        return QueriesHandler.qHandler(Constants.GET_ALL_CATEGORIES_QUERY, null, new Parameter.TYPE[]{Parameter.TYPE.STRING, Parameter.TYPE.BYTES});
    }
    public static ArrayList<QueriesHandler.ResultLine> getAllCategoriesNames() {
        return QueriesHandler.qHandler(Constants.GET_ALL_CATEGORIES_NAMES_QUERY, null, new Parameter.TYPE[]{Parameter.TYPE.STRING});
    }

    public static ArrayList<Object> getUserDetails(String username) {
        ArrayList<QueriesHandler.ResultLine> res = QueriesHandler.qHandler(Constants.GET_SUPERUSER_FIELDS, new Parameter[]{new Parameter(username, 1, Parameter.TYPE.STRING)},
                new Parameter.TYPE[]{Parameter.TYPE.STRING, Parameter.TYPE.STRING, Parameter.TYPE.STRING, Parameter.TYPE.STRING, Parameter.TYPE.STRING, Parameter.TYPE.INT});
        ArrayList<QueriesHandler.ResultLine> phones = QueriesHandler.qHandler(Constants.GET_ALL_USER_PHONES, new Parameter[]{new Parameter(username, 1, Parameter.TYPE.STRING)},
                new Parameter.TYPE[]{Parameter.TYPE.STRING, Parameter.TYPE.STRING, Parameter.TYPE.INT});
        ArrayList<Object> result = res.get(0).getContent();
        for (QueriesHandler.ResultLine r : phones) {
            result.addAll(r.getContent());
        }
        return result;

    }

    public static boolean checkIfUserNicknameAlreadyExists(String name) {
        return false;
    }

    public static boolean checkIfUserEmailAlreadyExists(String mail) {
        return false;
    }

    public static boolean createNewUser(UserBean user) {
        return true;
    }


    public static ArrayList<QueriesHandler.ResultLine> addCategory(String name, InputStream file, int len)

    {
        return QueriesHandler.updateQuery(Constants.ADD_CATEGORY_QUERY, new Parameter[]{new Parameter(name,1, Parameter.TYPE.STRING),new Parameter(file,2, Parameter.TYPE.BYTES,len)});
    }

    public static byte[] getCategoryImage(String name){
        ArrayList<QueriesHandler.ResultLine> res =
                QueriesHandler.qHandler(Constants.GET_CATEGORY_IMAGE_QUERY,new Parameter[]{new Parameter(name,1, Parameter.TYPE.STRING)},new Parameter.TYPE[]{Parameter.TYPE.BYTES});
        return (res!=null||res.size()>0)?(byte[])res.get(0).getContent().get(0):null;
    }
    public static byte[] getProductImage(String name){
        ArrayList<QueriesHandler.ResultLine> res =
                QueriesHandler.qHandler(Constants.GET_PRODUCT_IMAGE_QUERY,new Parameter[]{new Parameter(name,1, Parameter.TYPE.STRING)},new Parameter.TYPE[]{Parameter.TYPE.BYTES});
        return (res!=null||res.size()>0)?(byte[])res.get(0).getContent().get(0):null;
    }

    public static void addProduct (long productNumber,String productName,String description,float price, int quantity,float discount,boolean forSale,InputStream file,int size){
        QueriesHandler.updateQuery(Constants.ADD_PRODUCT_QUERY,new Parameter[]{new Parameter(productNumber,1, Parameter.TYPE.LONG),new Parameter(productName,2, Parameter.TYPE.STRING),
         new Parameter(description,8, Parameter.TYPE.STRING),new Parameter(price,3, Parameter.TYPE.FLOAT),new Parameter(quantity,4, Parameter.TYPE.INT),new Parameter(discount,6, Parameter.TYPE.FLOAT),
        new Parameter(forSale,5, Parameter.TYPE.BOOLEAN), new Parameter(file,7, Parameter.TYPE.BYTES,size)});
    }
}