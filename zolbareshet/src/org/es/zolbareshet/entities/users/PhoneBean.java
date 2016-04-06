package org.es.zolbareshet.entities.users;

import javax.faces.bean.ManagedBean;


@ManagedBean
public class PhoneBean {

    public enum phoneType {Home,Work, Mobile};
    private String perfix;
    private String phoneNumber;
    private phoneType type;
    private String id;

    public PhoneBean(){
        id="a"+Long.toString(System.currentTimeMillis());
    }


    public PhoneBean(String perfix, String phoneNumber) {
        this.perfix = perfix;
        this.phoneNumber = phoneNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public phoneType getType() {
        return type;
    }

    public void setType(phoneType type) {
        this.type = type;
    }

    public String getPerfix() {
        return perfix;
    }

    public void setPerfix(String perfix) {
        this.perfix = perfix;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }



}
