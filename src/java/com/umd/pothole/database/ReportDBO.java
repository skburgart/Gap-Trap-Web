package com.umd.pothole.database;

/**
 * @author Steven
 */
public class ReportDBO extends DatabaseObject {

    public boolean add(String androidid, double latitude, double longitude, double gforce) {

        String query = "INSERT INTO report(androidid, latitude, longitude, gforce) VALUES(?,?,?,?)";
        return update(query, androidid, latitude, longitude, gforce) != 0;
    }
}
