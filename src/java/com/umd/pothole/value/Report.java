package com.umd.pothole.value;

import java.sql.Timestamp;

/**
 * @author Steven
 */
public class Report {
    
    private int rid;
    private Device device;
    private Double latitude;
    private Double longitude;
    private double gforce;
    private Timestamp timestamp;

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public double getGforce() {
        return gforce;
    }

    public void setGforce(double gforce) {
        this.gforce = gforce;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
