package org.es.zolbareshet.entities.users;

import javax.faces.bean.ManagedBean;
import java.util.Date;


public class UserInfo {
    public enum gender{MALE,FEMALE};
    private gender userGender;
    private Date birthDate;
    private String mailAddress;

    public UserInfo(){

    }

    public UserInfo(gender userGender, Date birthDate, String mailAddress) {
        this.userGender = userGender;
        this.birthDate = birthDate;
        this.mailAddress=mailAddress;
    }

    public gender getUserGender() {
        return userGender;
    }

    public void setUserGender(gender userGender) {
        this.userGender = userGender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    public String toString(){
        return (userGender!=null?userGender+" ":"")+(birthDate!=null?birthDate+" ":"")+(mailAddress!=null?mailAddress+" ":"");
    }
}
