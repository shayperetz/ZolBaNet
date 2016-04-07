package org.es.zolbareshet.entities.orders;

import org.es.zolbareshet.entities.products.Product;
import org.es.zolbareshet.entities.users.User;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public abstract class  AbstractOrder {
    private User user;
    private Date date;
    private Map<Product,Integer> orderLines = new HashMap<Product,Integer>();

    public AbstractOrder(){

    }

    public AbstractOrder(User user, Date date, Map<Product, Integer> orderLines) {
        this.user = user;
        this.date = date;
        this.orderLines = orderLines;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Map<Product, Integer> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(Map<Product, Integer> orderLines) {
        this.orderLines = orderLines;
    }

}
