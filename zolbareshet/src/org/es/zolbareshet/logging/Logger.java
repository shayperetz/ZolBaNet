package org.es.zolbareshet.logging;


import javafx.util.Pair;

import java.util.List;

/**
 * Created by eilons on 3/28/2016.
 */
public abstract class Logger {


    public enum LEVEL {DEBUG, WARNING, INFO};

    public abstract void log(Logger.LEVEL level, String s);

    public abstract void destroy();

    public abstract List<Pair<String, Integer>> readLog();


}
