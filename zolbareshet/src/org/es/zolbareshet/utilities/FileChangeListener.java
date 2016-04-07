package org.es.zolbareshet.utilities;


import org.es.zolbareshet.services.Service;

import java.io.File;


/**
 * Created by eilons on 3/8/2016.
 */
public abstract class  FileChangeListener extends Service {
    private File file;
    private long timeStamp;
    private static final int FIFTEEN_SECONDS = 15000;
    private static final int TIME_TO_SLEEP=FIFTEEN_SECONDS;
    private volatile boolean keepRun=true;

    public FileChangeListener( File file, String name ) {
        super(name);
        this.file = file;
        this.timeStamp = file.lastModified();
    }

    public void run(){
        while(keepRun){
            runOnce();
            try {
                sleep(TIME_TO_SLEEP);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void runOnce(){
        long timeStamp = file.lastModified();
        if( this.timeStamp != timeStamp ) {
            this.timeStamp = timeStamp;
            propertyChanged();
        }
    }



    public void clean(){
        if (this.isAlive()) {
            stopRunning();
            try {
                this.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("stopping file listener");
        }
    }

    public void singleupdate() {
        long timeStamp = file.lastModified();
        if (this.timeStamp != timeStamp) {
            this.timeStamp = timeStamp;
            propertyChanged();
        }
    }

    public File getFile() {
        return file;
    }

    public abstract void propertyChanged();

    public void stopRunning(){
        keepRun=false;
    }


}
