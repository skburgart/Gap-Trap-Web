package com.umd.pothole.value;

import java.util.Date;

public class Report implements java.io.Serializable {

    private Integer rid;
    private Date timestamp;
    private Device device;
    private double latitude;
    private double longitude;
    private double gforce;

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getGforce() {
        return gforce;
    }

    public void setGforce(double gforce) {
        this.gforce = gforce;
    }

    
}
