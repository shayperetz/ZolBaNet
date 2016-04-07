package org.es.zolbareshet.entities.users;

import org.es.zolbareshet.logging.Logger;
import org.es.zolbareshet.logging.LoggerFactory;

import javax.faces.bean.ManagedProperty;
import java.util.ArrayList;


public abstract class User {
    public final int MAXIMUM_NUMBER_OF_PHONES=4;
    private boolean isActive=true;
    private Name name;
    private AddressBean addressBean;
    private ArrayList<PhoneBean> phonesList;
    private Password password;
    private String nickName;
    private UserInfo userInfo;
    private Logger logger = LoggerFactory.getLogger();;

    public User(){
        name=new Name();
        addressBean =new AddressBean();
        phonesList = new ArrayList<PhoneBean>();
        addPhone();
        password = new Password();
        userInfo = new UserInfo();

    }

    public User(Name name, AddressBean addressBean, ArrayList<PhoneBean> phonesList, Password password, String nickName, UserInfo userInfo) {
        this.name = name;
        this.addressBean = addressBean;
        this.phonesList = phonesList;
        this.password = password;
        this.nickName = nickName;
        this.userInfo = userInfo;
    }

    public void addPhone(){
        if (phonesList.size()<MAXIMUM_NUMBER_OF_PHONES){
            phonesList.add(new PhoneBean());
        }
    }

    public void removePhone(){
        if(phonesList.size()>1){
            phonesList.remove(phonesList.size()-1);
        }
    }

    public ArrayList<PhoneBean> getPhonesList() {
        return phonesList;
    }

    public void setPhonesList(ArrayList<PhoneBean> phonesList) {
        this.phonesList = phonesList;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public AddressBean getAddressBean() {
        return addressBean;
    }

    public void setAddressBean(AddressBean addressBean) {
        this.addressBean = addressBean;
    }


    public Password getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = new Password(password);
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public Logger getLogger() {
        return logger;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    public String toString(){
        return  (name!=null?name+" ":"")+(addressBean !=null? addressBean +" ":"")+(userInfo!=null?userInfo+" ":"")+(password!=null?password+" ":"")+(nickName!=null?nickName+" ":"");
    }

   public abstract String register();

    public void clearUser(){
        name=new Name();
        addressBean =new AddressBean();
        phonesList=new ArrayList<PhoneBean>();
        addPhone();
        password=null;
        nickName=null;
        userInfo=new UserInfo();
    }
}
