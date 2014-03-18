package com.umd.pothole.value;

import java.sql.Timestamp;

/**
 * @author Steven
 */
public class Device {
    
    private int did;
    private String androidid;
    private Timestamp registered;

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public String getAndroidid() {
        return androidid;
    }

    public void setAndroidid(String androidid) {
        this.androidid = androidid;
    }

    public Timestamp getRegistered() {
        return registered;
    }

    public void setRegistered(Timestamp registered) {
        this.registered = registered;
    }
}
