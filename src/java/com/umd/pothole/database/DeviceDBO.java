package com.umd.pothole.database;

import com.umd.pothole.value.Device;

/**
 * @author Steven Burgart <skburgart@gmail.com>
 */
public class DeviceDBO extends DatabaseObject {

    public boolean add(String androidid) {

        String query = "INSERT INTO device(androidid) VALUES(?)";
        return update(query, androidid) != 0;
    }

    public boolean add(Device d) {

        return add(d.getAndroidid());
    }

    public boolean addIfNotRegistered(String androidid) {

        String query = "SELECT * FROM device WHERE androidid=?";
        
        if (rowExists(query, androidid)) {
            return true;
        }

        return add(androidid);
    }

    public boolean addIfNotRegistered(Device d) {

        return addIfNotRegistered(d.getAndroidid());
    }
}
