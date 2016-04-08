package org.es.zolbareshet.orders;

import org.es.zolbareshet.entities.products.ProductBean;
import org.es.zolbareshet.entities.users.User;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public abstract class  AbstractOrder {
    private User user;
    private Date date;
    private Map<ProductBean,Integer> orderLines = new HashMap<ProductBean,Integer>();

    public AbstractOrder(){

    }

    public AbstractOrder(User user, Date date, Map<ProductBean, Integer> orderLines) {
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

    public Map<ProductBean, Integer> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(Map<ProductBean, Integer> orderLines) {
        this.orderLines = orderLines;
    }
    public abstract boolean commitOrder();
    public abstract boolean addProduct(ProductBean p, int quantity);
    public abstract boolean removeProduct(ProductBean p);
    public abstract boolean incrementProductQuantity(ProductBean p, int quantity);
    public abstract boolean decrementProductQuantity(ProductBean p, int quantity);
}
