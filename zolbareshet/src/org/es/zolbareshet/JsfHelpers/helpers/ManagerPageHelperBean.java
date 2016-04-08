package org.es.zolbareshet.JsfHelpers.helpers;

import javafx.util.Pair;
import org.es.zolbareshet.logging.MainLogger;
import org.es.zolbareshet.queries.QueriesHandler;
import org.es.zolbareshet.queries.SimpleQueryInvoker;
import org.es.zolbareshet.services.Service;
import org.es.zolbareshet.services.ServiceManager;
import org.es.zolbareshet.utilities.PropertiesFileManager;
import javax.faces.bean.ManagedBean;
import java.awt.*;
import java.io.IOException;
import java.util.*;
import java.util.List;


@ManagedBean
public class ManagerPageHelperBean {

    public static void openConfigFile(){
        Desktop desktop = Desktop.getDesktop();
        try {
            desktop.open(PropertiesFileManager.getConfigFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void clearLog(){
      /*  int result = JOptionPane.showConfirmDialog(null,"This will delete the content of the log file, do you confirm this action?","DELETE LOG",JOptionPane.YES_NO_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION){*/
            MainLogger.clearLog();
      //  }
    }

    public static List<Pair<String, Integer>> readLog(){
        return MainLogger.readLog();
    }

    public  ArrayList<Service> getServices(){
        return ServiceManager.getServicesList();
    }

    public static  ArrayList<String> getConfigFile(){
        return PropertiesFileManager.readFile();
    }
    public static ArrayList<ArrayList<String>> getSuperUsers(){
        ArrayList<QueriesHandler.ResultLine> result = SimpleQueryInvoker.getAllSuperUsers();
        ArrayList<ArrayList<String>> superusers = new ArrayList<>();
        for (QueriesHandler.ResultLine r: result){
                ArrayList<String> list = new ArrayList<String >();
                list.add((String)r.getContent().get(0));
                list.add((String)r.getContent().get(1));
                superusers.add(list);

        }
        return superusers;
    }




}

