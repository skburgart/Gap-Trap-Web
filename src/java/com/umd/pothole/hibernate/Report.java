package com.umd.pothole.hibernate;
// Generated Mar 18, 2014 12:41:00 PM by Hibernate Tools 3.6.0


import java.util.Date;

/**
 * Report generated by hbm2java
 */
public class Report implements java.io.Serializable {


     private Integer rid;
     private Date timestamp;
     private Device device;
     private double latitude;
     private double longitude;
     private double gforce;

    public Report() {
    }

    public Report(Device device, double latitude, double longitude, double gforce) {
       this.device = device;
       this.latitude = latitude;
       this.longitude = longitude;
       this.gforce = gforce;
    }
   
    public Integer getRid() {
        return this.rid;
    }
    
    public void setRid(Integer rid) {
        this.rid = rid;
    }
    public Date getTimestamp() {
        return this.timestamp;
    }
    
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
    public Device getDevice() {
        return this.device;
    }
    
    public void setDevice(Device device) {
        this.device = device;
    }
    public double getLatitude() {
        return this.latitude;
    }
    
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
    public double getLongitude() {
        return this.longitude;
    }
    
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
    public double getGforce() {
        return this.gforce;
    }
    
    public void setGforce(double gforce) {
        this.gforce = gforce;
    }




}


