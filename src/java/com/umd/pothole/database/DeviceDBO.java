package com.umd.pothole.database;

import com.umd.pothole.hibernate.HibernateUtil;
import org.hibernate.Session;

/**
 * @author Steven
 */
public class DeviceDBO {

    Session session = null;

    public DeviceDBO() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
}
