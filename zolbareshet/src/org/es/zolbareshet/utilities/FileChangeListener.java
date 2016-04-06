package org.es.zolbareshet.utilities;


import java.io.File;
import java.io.FileInputStream;

/**
 * Created by eilons on 3/8/2016.
 */
public abstract class  FileChangeListener extends Thread{
    private File file;
    private long timeStamp;
    private static final int FIFTEEN_SECONDS = 15000;
    private static final int TIME_TO_SLEEP=FIFTEEN_SECONDS;
    private volatile boolean keepRun=true;

    public FileChangeListener( File file ) {
        this.file = file;
        this.timeStamp = file.lastModified();
    }

    public void run(){
        while(keepRun){
            long timeStamp = file.lastModified();
            if( this.timeStamp != timeStamp ) {
                this.timeStamp = timeStamp;
                propertyChanged();
            }
            try {
                sleep(TIME_TO_SLEEP);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
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
