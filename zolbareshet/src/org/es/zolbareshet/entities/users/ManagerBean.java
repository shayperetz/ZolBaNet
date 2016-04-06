package org.es.zolbareshet.entities.users;

import javax.faces.bean.ManagedBean;
import java.util.ArrayList;


@ManagedBean
public class ManagerBean extends User{

    private String[] roles;
    public ManagerBean(){
        super();
    }

    public ManagerBean(Name name, AddressBean addressBean, ArrayList<PhoneBean> phoneNumbers, Password password, String nickName, UserInfo userInfo, String[] roles) {
        super( name, addressBean, phoneNumbers, password, nickName, userInfo);
        this.roles = roles;
    }

    public String[] getRoles() {
        return roles;
    }

    public void setRoles(String[] roles) {
        this.roles = roles;
    }

    public String register(){
        return "";
    }

}
