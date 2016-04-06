package org.es.zolbareshet.orders;



import com.sun.xml.internal.bind.v2.TODO;
import org.es.zolbareshet.entities.products.Product;
import org.es.zolbareshet.entities.users.User;
import org.es.zolbareshet.logging.Logger;
import org.es.zolbareshet.logging.LoggerFactory;
import org.es.zolbareshet.queries.QueriesHandler;
import org.es.zolbareshet.utilities.Constants;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.concurrent.TimeUnit;


@ManagedBean
@SessionScoped
public class Order extends AbstractOrder{

    private long  orderID ;
    private boolean closed = false;
    private static Logger logger = LoggerFactory.getLogger();


    public enum closeCause {USER_CANCELED,EXPIRED,ADMIN_CLOSE,PAID};

    static{
        new OrdersChecker().start();
    }

    public Order(long orderID, boolean closed, User user, Date date, Map<Product, Integer> orderLines) {
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
    public boolean commitOrder() {
        return false;
    }

    @Override
    public boolean addProduct(Product p, int quantity) {
        return false;
    }

    @Override
    public boolean removeProduct(Product p) {
        return false;
    }

    @Override
    public boolean incrementProductQuantity(Product p, int quantity) {
        return false;
    }

    @Override
    public boolean decrementProductQuantity(Product p, int quantity) {
        return false;
    }

    public static void close(Order o , closeCause cause){
        String[] p = {Long.toString(o.getOrderID())};
        QueriesHandler.creatingQuery(Constants.DELETE_ORDER_QUERY,p);
        logger.log(Logger.LEVEL.DEBUG,"order "+ o.orderID + " of user " + o.getUser().getNickName() + " was removed by: " + cause  );
    }

    private static class OrdersChecker extends Thread{
        private static long TIME_BETWEEN_RUNS = 1000*60*60*24; //run once a day;

        public void run() {
            ArrayList<Order> orders = getAllOrders();
            for (Order o : orders){
                if ((o.getDate().getTime() - System.currentTimeMillis())> Constants.ORDER_EXPIRE_AFTER){
                    close(o, closeCause.EXPIRED);
                }
            }
        }
        public ArrayList<Order> getAllOrders(){
            ArrayList<Order> list = new ArrayList<>();
            String[] parameters = {Constants.ORDERS_TABLE,Constants.ORDERID_FIELD};
          /*  ResultSet res =  QueriesHandler.getResultQuery(Constants.GET_ALL_FROM_TABLE_QUERY,parameters);*/
          /*  try {
                while (res.next() ) {
                    list.add(new Order(res.getString(Constants.ORDERID_FIELD));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }*/
            return list;
        }

    }




}
