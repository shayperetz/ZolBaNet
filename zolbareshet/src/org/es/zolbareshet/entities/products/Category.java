package org.es.zolbareshet.entities.products;


import org.es.zolbareshet.queries.QueriesHandler;
import org.es.zolbareshet.queries.SimpleQueryInvoker;
import org.es.zolbareshet.utilities.Constants;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import static jdk.nashorn.internal.codegen.CompilerConstants.CONSTANTS;

@ManagedBean
public class Category {
    private String name;
    private byte[] image;
    private static Map<String,byte[]> categories;
    private static boolean initialized=false;


public Category(){

}

    public Category(String name, byte[] image) {
        this.name = name;
        this.image = image;
    }

    @PostConstruct
    private void init(){
       if(!initialized) {
           categories = new HashMap<>();
           ArrayList<QueriesHandler.ResultLine> catList = SimpleQueryInvoker.getAllCategories();
           for (QueriesHandler.ResultLine r : catList) {
               categories.put((String) r.getContent().get(0), (byte[]) r.getContent().get(1));
           }
           initialized=true;
       }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public  Map<String, byte[]> getCategories() {
        return categories;
    }

    public  void setCategories(Map<String, byte[]> categories) {
        Category.categories = categories;
    }

    public ArrayList<String> getCategoriesNames(){
        ArrayList<String> l = new ArrayList<String>();
        l.addAll(categories.keySet());
        return l;
    }
}
