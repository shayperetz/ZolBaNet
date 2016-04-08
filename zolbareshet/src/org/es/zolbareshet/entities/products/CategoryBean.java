package org.es.zolbareshet.entities.products;


import org.es.zolbareshet.queries.QueriesHandler;
import org.es.zolbareshet.queries.SimpleQueryInvoker;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.*;

@ManagedBean
public class CategoryBean implements Serializable{
    private String name;
    private byte[] image;
    private static Map<String,byte[]> categories;
    private static boolean initialized=false;


public CategoryBean(){

}

    public CategoryBean(String name, byte[] image) {
        this.name = name;
        this.image = image;
    }

    @PostConstruct
    private void init(){
       if(!initialized) {
           categories = new HashMap<>();
           ArrayList<QueriesHandler.ResultLine> catList = SimpleQueryInvoker.getAllCategories();
           if(catList!=null) {
               for (QueriesHandler.ResultLine r : catList) {
                   categories.put((String) r.getContent().get(0), (byte[]) r.getContent().get(1));
               }
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
        CategoryBean.categories = categories;
    }

    public ArrayList<String> getCategoriesNames(){
        ArrayList<String> l = new ArrayList<String>();
        l.addAll(categories.keySet());
        return l;
    }
}
