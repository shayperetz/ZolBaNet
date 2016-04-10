package org.es.zolbareshet.utilities;


import javax.faces.bean.ManagedBean;
import java.io.*;
import java.util.ArrayList;
import java.util.Properties;


public class PropertiesFileManager {
    private static final Properties prop;
    private static File configFile = null;
    private static FileInputStream stream;


    static{
        prop = new Properties();
        try {
            StringBuilder pathToJarFile = new StringBuilder(PropertiesFileManager.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath());
            String pathToParentDirectory = pathToJarFile.substring(0, pathToJarFile.lastIndexOf("/"));
            pathToParentDirectory = pathToParentDirectory.substring(0, pathToParentDirectory.lastIndexOf("/"));
            String configFileFullName = pathToParentDirectory + "/" + Constants.PROPERTY_FILE_NAME;
            configFile = new File(configFileFullName);
            stream = new FileInputStream(configFile);
            prop.load(stream);
        }catch (Exception ex) {
            System.out.println("ERROR: CAN'T OPEN CONFIGURATION FILE");
            System.exit(1);
        }
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                PropertiesFileManager.destroy();
            }
        });
    }


    public static Properties getProp() {
        return prop;
    }

    public static File getConfigFile() {
        return configFile;
    }

    public static void load() throws Exception{

        prop.load(stream);

    }

    public  synchronized static void destroy() {
        if (stream != null) {
            try {
                stream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("releasing configuration file");
        }
    }

    public static ArrayList<String> readFile() {
        BufferedReader br = null;
        ArrayList<String> configLine = new ArrayList<String>();
        try {
            br = new BufferedReader(new FileReader(configFile));
            String line = br.readLine();
            while (line != null && line.length()>0) {
                if(line.charAt(0)!='#') {
                    configLine.add(line);
                }
                line = br.readLine();
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return configLine;
    }

}
