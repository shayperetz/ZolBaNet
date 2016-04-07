package org.es.zolbareshet.utilities;


import javax.faces.context.FacesContext;
import java.util.Properties;

public class Utils {
    public static <T> T findBean(String beanName) {
        FacesContext context = FacesContext.getCurrentInstance();
        return (T) context.getApplication().evaluateExpressionGet(context, "#{" + beanName + "}", Object.class);
    }

    public static String getPropertyOrDefault(String propertyName,String defaultvalue){
        Properties prop = PropertiesFileManager.getProp();
        String res = prop.getProperty(propertyName);
        return (res!=null&&!res.equals(""))?res:defaultvalue;
    }
}
