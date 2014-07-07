package com.umd.pothole.value;

import java.util.Date;

public class Device {

    private String androidid;
    private Date registered;

    public String getAndroidid() {
        return androidid;
    }

    public void setAndroidid(String androidid) {
        this.androidid = androidid;
    }

    public Date getRegistered() {
        return registered;
    }

    public void setRegistered(Date registered) {
        this.registered = registered;
    }
}
