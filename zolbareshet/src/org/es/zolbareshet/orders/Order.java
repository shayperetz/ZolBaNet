package org.es.zolbareshet.orders;



import org.es.zolbareshet.entities.products.ProductBean;
import org.es.zolbareshet.entities.users.User;
import org.es.zolbareshet.logging.Logger;
import org.es.zolbareshet.logging.LoggerFactory;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.*;


@ManagedBean
@SessionScoped
public class Order extends AbstractOrder {

    private long  orderID ;
    private boolean closed = false;
    private static Logger logger = LoggerFactory.getLogger();



    public Order(long orderID, boolean closed, User user, Date date, Map<ProductBean, Integer> orderLines) {
        super(user,date,orderLines);
        this.orderID = orderID;
        this.closed = closed;
    }

    public Order(){

    }

    public long getOrderID() {
        return orderID;
    }

    public void setOrderID(long orderID) {
        this.orderID = orderID;
    }

    public boolean isClosed() {
        return closed;
    }

    @Override
    public boolean addProduct(ProductBean p, int quantity) {
        return false;
    }

    @Override
    public boolean removeProduct(ProductBean p) {
        return false;
    }

    @Override
    public boolean incrementProductQuantity(ProductBean p, int quantity) {
        return false;
    }

    @Override
    public boolean decrementProductQuantity(ProductBean p, int quantity) {
        return false;
    }

    public boolean commitOrder() {
        return false;
    }






}
