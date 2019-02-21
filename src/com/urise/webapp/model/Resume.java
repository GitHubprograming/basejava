package com.urise.webapp.model;

/**
 * Initial resume class
 */
public class Resume {

    // Unique identifier
    String uuid;

    public Resume(String uuid){
        this.uuid = uuid;
    }

    public void setUuid(String uuid){
        this.uuid = uuid;
    }

    public String getUuid(){
        return uuid;
    }

    @Override
    public String toString() {
        return uuid;
    }
}
