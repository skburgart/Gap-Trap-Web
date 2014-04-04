package com.umd.pothole.database;

import com.umd.pothole.value.Device;
import com.umd.pothole.value.Report;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.log4j.Logger;

/**
 * @author Steven Burgart <skburgart@gmail.com>
 */
public class ReportDBO extends DatabaseObject {

    private static final Logger log = Logger.getLogger(ReportDBO.class.getName());

    public boolean add(String androidid, double latitude, double longitude, double gforce) {

        String query = "INSERT INTO report(androidid, latitude, longitude, gforce) VALUES(?, ?, ?, ?)";

        // Add device if not registered
        DeviceDBO ddbo = new DeviceDBO();
        ddbo.addIfNotRegistered(androidid);
        ddbo.close();

        log.info("Adding report for " + androidid);
        return update(query, androidid, latitude, longitude, gforce) != 0;
    }

    public boolean add(Report r) {

        return add(r.getDevice().getAndroidid(), r.getLatitude(), r.getLongitude(), r.getGforce());
    }

    public List<Report> getAllReports() {

        String query = "SELECT rid, androidid, latitude, longitude, gforce, timestamp FROM report";
        return parseResult(select(query));
    }

    private ArrayList<Report> parseResult(ArrayList<HashMap> result) {

        ArrayList<Report> reports = new ArrayList<>();
        for (HashMap row : result) {
            Report r = new Report();
            Device d = new Device();

            d.setAndroidid((String) row.get("androidid"));
            r.setRid(((Number) row.get("rid")).intValue());
            r.setLatitude((Double) row.get("latitude"));
            r.setLongitude((Double) row.get("longitude"));
            r.setGforce((Double) row.get("gforce"));
            r.setTimestamp((Timestamp) row.get("timestamp"));
            r.setDevice(d);
            reports.add(r);
        }

        return reports;
    }
}
