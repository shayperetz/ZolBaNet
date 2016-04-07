package org.es.zolbareshet.logging;

import javafx.util.Pair;
import org.es.zolbareshet.services.ServiceManager;
import org.es.zolbareshet.utilities.Constants;
import org.es.zolbareshet.utilities.FileChangeListener;
import org.es.zolbareshet.utilities.PropertiesFileManager;
import org.es.zolbareshet.utilities.Utils;

import javax.faces.bean.ManagedBean;
import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;

//singelton
public class MainLogger extends Logger {
    private static File logFile = null;
    private String LOG_FILE_NAME;
    private String level;
    private PrintStream stdout = null;
    private static volatile MainLogger logger;

    // SETTING THE LOG FILE
    private MainLogger() {


        try {

            LOG_FILE_NAME = Utils.getPropertyOrDefault(Constants.LOG_FILE_NAME_PROPERTY, null);
            level = Utils.getPropertyOrDefault(Constants.DEBUGGING_LEVEL_PROPERTY, "INFO");
            if (LOG_FILE_NAME == null || LOG_FILE_NAME.trim().equals("")) {
                throw new Exception();
            }
            try {
                Files.createDirectories(Paths.get(LOG_FILE_NAME.substring(0, LOG_FILE_NAME.lastIndexOf('/'))));
                Files.createFile(Paths.get(LOG_FILE_NAME));

            } catch (FileAlreadyExistsException ignored) {
                //file exists do nothing
            } catch (Exception e) {
                System.out.println("ERROR: CAN'T CREATE LOG FILE");
                System.exit(1);
            }
            try {
                logFile = new File(LOG_FILE_NAME);
                ServiceManager.addService(new LogFileListener(PropertiesFileManager.getConfigFile()));
                stdout = new PrintStream(new FileOutputStream(logFile, true));


            } catch (Exception e) {
                System.out.println("ERROR: CAN'T OPEN LOG FILE");
                System.exit(1);
            }
        } catch (Exception ex) {
            System.out.println("ERROR: CAN'T OPEN CONFIGURATION FILE");
            System.exit(1);
        }
        stdout.append("\n*************************************************************************************************************************************************\n");
        log(LEVEL.INFO, "log started successfully.... ");
    }


    public synchronized void log(LEVEL lev, String msg) {

        if (lev.equals(LEVEL.INFO)) {
            stdout.append(new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz").format(new Date()) + "\t\t|INFO|   \t\t" + msg + "\n");
        } else if (lev.equals(LEVEL.WARNING)) {
            stdout.append(new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz").format(new Date()) + "\t\t|WARNING|\t\t" + msg + "\n");
        } else {
            if (level.equals(LEVEL.DEBUG.name())) {
                stdout.append(new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz").format(new Date()) + "\t\t|DEBUG|  \t\t" + msg + "\n");
            }
        }

    }

    class LogFileListener extends FileChangeListener {
        public LogFileListener(File file) {
            super(file, "file change listener for configuration file");
        }


        @Override
        public void propertyChanged() {

            try {
                PropertiesFileManager.load();
            } catch (Exception e) {
                e.printStackTrace();
            }

            level = Utils.getPropertyOrDefault(Constants.DEBUGGING_LEVEL_PROPERTY, "INFO");
        }

    }

    public static File getLogFile() {
        return logFile;
    }

    public static Logger getLogger() {
        if (logger == null) {
            synchronized (MainLogger.class) {
                if (logger == null) {
                    logger = new MainLogger();
                    Runtime.getRuntime().addShutdownHook(new Thread() {
                        public void run() {
                            logger.destroy();
                        }
                    });
                }
            }
        }

        return logger;

    }


    public synchronized void destroy() {
        try {

            if (stdout != null) {
                logger.log(LEVEL.INFO, "server is shutting down....");
                stdout.close();
                System.out.println("closing log file");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static synchronized List<Pair<String, Integer>> readLog() {
        BufferedReader br = null;
        int i=0;
        List<Pair<String, Integer>> logLines = new ArrayList<>();
        try {
            br = new BufferedReader(new FileReader(logFile));
            String line = br.readLine();
            while (line != null) {
                logLines.add(new Pair<String, Integer>(line,i++));
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
        return logLines;
    }

    public static synchronized void clearLog(){
        try {
            PrintWriter p = new PrintWriter(logFile);
            p.write("");
            p.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
