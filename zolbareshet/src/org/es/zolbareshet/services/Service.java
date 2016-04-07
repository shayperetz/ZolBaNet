package org.es.zolbareshet.services;

import javax.faces.bean.ManagedBean;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by eilons on 4/3/2016.
 */
@ManagedBean
public abstract class Service extends Thread {

    private String displayName = "abstract service";

    public Service(String name){
        displayName=name;
    }

    public abstract void clean();

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public abstract void runOnce();
}

