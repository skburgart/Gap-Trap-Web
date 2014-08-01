package com.umd.pothole.value;

import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.apache.log4j.Logger;

@Entity
@Table(name = "device")
public class Device {

    private static final Logger log = Logger.getLogger(Device.class.getName());

    @Id
    @Column(nullable = false)
    private String androidid;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date registered;

    @OneToMany(mappedBy = "device")
    private Set<Report> reports;

    public Device() {
        // default constructor
    }

    public Device(String androidid, Date registered) {
        this.androidid = androidid;
        this.registered = registered;
    }

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

    public Set<Report> getReports() {
        return reports;
    }

    public void setReports(Set<Report> reports) {
        this.reports = reports;
    }
}
