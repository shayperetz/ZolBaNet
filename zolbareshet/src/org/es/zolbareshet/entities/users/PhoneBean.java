package org.es.zolbareshet.entities.users;

import org.es.zolbareshet.utilities.Constants;

import javax.faces.bean.ManagedBean;
import java.io.Serializable;


@ManagedBean
public class PhoneBean implements Serializable{

    public enum phoneType {Home,Work, Mobile};
    private String perfix;
    private String phoneNumber;
    private phoneType type;



    public phoneType getType() {
        return type;
    }

    public void setType(int type) {

        switch(type){
            case Constants.HOME:
                this.type=phoneType.Home;
                break;
            case Constants.MOBILE:
                this.type=phoneType.Mobile;
                break;
           case Constants.WORK:
                this.type=phoneType.Work;
        }
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
