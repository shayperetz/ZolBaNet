package org.es.zolbareshet.entities.users;

import javax.faces.bean.ManagedBean;
import java.io.Serializable;



public class Name implements Serializable{
    private String firstName;
    private String lastName;
    public Name() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String toString(){
      return firstName + " "  + lastName;
    }
}
