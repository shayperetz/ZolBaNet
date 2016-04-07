package org.es.zolbareshet.queries;

import javafx.util.Pair;


public class Parameter {
    public enum TYPE {STRING,INT,FLOAT,LONG,BOOLEAN,BLOB,DATE,BYTES};
    private Object object;
    private int index;
    private TYPE type;
    private int fileLength; //for bytes parameter

    public Parameter(Object object, int index, TYPE type) {
        this(object,index,type,0);
    }

    public Parameter(Object object, int index, TYPE type, int fileLength) {
        this.object = object;
        this.index = index;
        this.type = type;
        this.fileLength = fileLength;
    }

    public int getFileLength() {
        return fileLength;
    }

    public void setFileLength(int fileLength) {
        this.fileLength = fileLength;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public TYPE getType() {
        return type;
    }

    public void setType(TYPE type) {
        this.type = type;
    }
}
