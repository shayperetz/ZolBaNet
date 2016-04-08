package org.es.zolbareshet.entities.users;



import org.es.zolbareshet.JsfHelpers.helpers.ManagerPageNavigation;
import org.es.zolbareshet.logging.MainLogger;
import org.es.zolbareshet.orders.Cart;
import org.es.zolbareshet.payments.CreditCard;
import org.es.zolbareshet.queries.SimpleQueryInvoker;
import org.es.zolbareshet.utilities.Constants;
import org.es.zolbareshet.utilities.Utils;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;



@ManagedBean
@SessionScoped
public class UserBean extends User {
    private CreditCard creditCard;
    private Cart cart;
    private Role role;
    private boolean nickNameAlreadyExists=false;
    private boolean emailAlreadyExists=false;
    public enum Role {ADMINISTRATOR,STOREKEEPER,CUSTOMER};


    public UserBean(){
        super();
        role = Role.CUSTOMER;
    }
    public UserBean(Name name, AddressBean addressBean, ArrayList<PhoneBean> phoneNumbers, Password password, String nickName, UserInfo userInfo, CreditCard creditCard, Cart cart) {
        super( name, addressBean, phoneNumbers, password, nickName, userInfo);
        this.creditCard = creditCard;
        this.cart = cart;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(int role) {
        switch(role){
            case Constants.ADMINISTRATOR:
                this.role=Role.ADMINISTRATOR;
                break;
            case Constants.STOREKEEPER:
                this.role=Role.STOREKEEPER;
                break;
            default:
                this.role=Role.CUSTOMER;
        }
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
        if (SimpleQueryInvoker.checkIfUserNicknameAlreadyExists(getNickName())) {
           if (SimpleQueryInvoker.checkIfUserEmailAlreadyExists(getUserInfo().getMailAddress())) {
                if (SimpleQueryInvoker.createNewUser(this)){
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
        clearUserBean();
            return  Constants.MAIN_PAGE;


}

    public String update(){
        return "";
    }

    public void clearUserBean(){
        super.clearUser();
        nickNameAlreadyExists=false;
        emailAlreadyExists=false;
        cart=new Cart();
        creditCard=new CreditCard();
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

    public  ArrayList<String> getRoles(){
        ArrayList<String> roles = new ArrayList<>();
        for(Role r:Role.values()){
            if(r!=Role.CUSTOMER) {
                roles.add(r.toString());
            }
        }
        return roles;
    }
    public void editSuperUser(String userName){
        ArrayList<Object> userDetails = SimpleQueryInvoker.getUserDetails(userName);
        int index=0;
        setNickName((String)userDetails.get(index++));
        getName().setFirstName((String)userDetails.get(index++));
        getName().setLastName((String)userDetails.get(index++));
        setPassword((String)userDetails.get(index++));
        getUserInfo().setMailAddress((String)userDetails.get(index++));
        setRole(Integer.parseInt((String)userDetails.get(index++)));
        int phoneIndex=0;
        getPhonesList().get(phoneIndex).setPerfix((String)userDetails.get(index++));
        getPhonesList().get(phoneIndex).setPhoneNumber((String)userDetails.get(index++));
        getPhonesList().get(phoneIndex++).setType(Integer.parseInt((String)userDetails.get(index++)));
        for(;index<userDetails.size() && phoneIndex<MAXIMUM_NUMBER_OF_PHONES;){
            addPhone();
            getPhonesList().get(phoneIndex).setPerfix((String)userDetails.get(index++));
            getPhonesList().get(phoneIndex).setPhoneNumber((String)userDetails.get(index++));
            getPhonesList().get(phoneIndex++).setType(Integer.parseInt((String)userDetails.get(index++)));
        }
        ManagerPageNavigation m = Utils.findBean("managerPageNavigation");
        m.changeContext(m.EDIT_USER);
    }
}
