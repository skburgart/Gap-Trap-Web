package com.umd.pothole.database;

/**
 * @author Steven
 */
public class DeviceDBO extends DatabaseObject {

    public boolean add(String androidid) {

        String query = "INSERT INTO device(androidid) VALUES(?)";
        return update(query, androidid) != 0;
    }
}
