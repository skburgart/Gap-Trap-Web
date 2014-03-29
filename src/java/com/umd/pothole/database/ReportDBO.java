package com.umd.pothole.database;

import com.umd.pothole.hibernate.Device;
import com.umd.pothole.hibernate.HibernateUtil;
import com.umd.pothole.hibernate.Report;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @author Steven Burgart <skburgart@gmail.com>
 */
public class ReportDBO {

    Session session = null;

    public ReportDBO() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    public boolean add(String androidid, double latitude, double longitude, double gforce) {

        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Report report = new Report();
            Device device = (Device) session.get(Device.class, androidid);
            if (device == null) {
                device = new Device();
                device.setAndroidid(androidid);
                session.save(device);
            }
            report.setDevice(device);
            report.setLatitude(latitude);
            report.setLongitude(longitude);
            report.setGforce(gforce);
            session.save(report);
            tx.commit();
        } catch (HibernateException he) {
            if (tx != null) {
                tx.rollback();
            }
            return false;
        } catch (IllegalArgumentException iae) {
            return false;
        }
        return true;
    }

    public List<Report> getAllReports() {

        List<Report> reports = null;

        try {
            Transaction tx = session.beginTransaction();
            reports = session.createCriteria(Report.class).list();
            tx.commit();
        } catch (HibernateException ex) {
            // nothing
        }

        return reports;
    }
}
