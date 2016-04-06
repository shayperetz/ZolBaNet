package org.es.zolbareshet.entities.users;



import org.es.zolbareshet.payments.CreditCard;
import org.es.zolbareshet.logging.MainLogger;
import org.es.zolbareshet.queries.QueriesHandler;
import org.es.zolbareshet.orders.Cart;
import org.es.zolbareshet.utilities.Constants;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;



@ManagedBean
@SessionScoped
public class CustomerBean extends User {
    private CreditCard creditCard;
    private Cart cart;
    private boolean nickNameAlreadyExists=false;
    private boolean emailAlreadyExists=false;



    public CustomerBean(){
        super();
    }
    public CustomerBean(Name name, AddressBean addressBean, ArrayList<PhoneBean> phoneNumbers, Password password, String nickName, UserInfo userInfo, CreditCard creditCard, Cart cart) {
        super( name, addressBean, phoneNumbers, password, nickName, userInfo);
        this.creditCard = creditCard;
        this.cart = cart;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public String register(){
        if (QueriesHandler.checkingQuery(Constants.CHECKING_NEW_USER_NICKNAME_REGISTRATION_QUERY,null)) {
           if (QueriesHandler.checkingQuery(Constants.CHECKING_NEW_USER_EMAIL_REGISTRATION_QUERY,null)) {
                if (QueriesHandler.creatingQuery(Constants.ADD_NEW_USER_QUERY,null)) {
                    getLogger().log(MainLogger.LEVEL.INFO, "user " + getName() + " was successfully registered");
                } else {
                    getLogger().log(MainLogger.LEVEL.WARNING, "user " + getName() + " was unable to register, seek for relevant exceptions in the log for more details");
                }
            } else {
                emailAlreadyExists = true;
                return Constants.REGISTRATION_PAGE;
            }
        }
        else {
            nickNameAlreadyExists = true;
            return Constants.REGISTRATION_PAGE;
        }
    //success registration
        clearCustomer();
            return  Constants.HOME_PAGE;


}

    private void clearCustomer(){
        super.clearUser();
        nickNameAlreadyExists=false;
        emailAlreadyExists=false;
        cart=null;
        creditCard=null;
    }

    public boolean isNickNameAlreadyExists() {
        return nickNameAlreadyExists;
    }

    public void setNickNameAlreadyExists(boolean nickNameAlreadyExists) {
        this.nickNameAlreadyExists = nickNameAlreadyExists;
    }

    public boolean isEmailAlreadyExists() {
        return emailAlreadyExists;
    }

    public void setEmailAlreadyExists(boolean emailAlreadyExists) {
        this.emailAlreadyExists = emailAlreadyExists;
    }
}
