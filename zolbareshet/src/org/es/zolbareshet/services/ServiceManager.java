package org.es.zolbareshet.services;

import javax.faces.bean.ManagedBean;
import java.util.ArrayList;

/**
 * Created by eilons on 4/3/2016.
 */
public class ServiceManager {

    private static ArrayList<Service> services = new ArrayList<>();

    public static void addService(Service service) {
        services.add(service);
        service.start();
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                service.clean();
            }
        });
    }

    public static ArrayList<Service> getServicesList(){
        return services;
    }

}
