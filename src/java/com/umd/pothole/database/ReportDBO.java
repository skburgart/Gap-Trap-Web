package com.umd.pothole.database;

import com.umd.pothole.hibernate.Device;
import com.umd.pothole.hibernate.HibernateUtil;
import com.umd.pothole.hibernate.Report;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @author Steven
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
            Report r = new Report();
            Device d = new Device();
            d.setAndroidid(androidid);
            session.saveOrUpdate(d);
            r.setDevice(d);
            r.setLatitude(latitude);
            r.setLongitude(longitude);
            r.setGforce(gforce);
            session.save(r);
            tx.commit();
        } catch (HibernateException he) {
            if (tx != null) {
                tx.rollback();
            }
            
            he.printStackTrace();
            return false;
        }

        return true;
    }
}
