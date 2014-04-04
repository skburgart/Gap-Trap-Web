package com.umd.pothole.database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.log4j.Logger;

public abstract class DatabaseObject {

    private static final Logger log = Logger.getLogger(DatabaseObject.class.getName());
    private Connection conn;

    protected DatabaseObject() {
        try {
            Class.forName(PotholeConfig.get("jdbc.driver"));
            conn = DriverManager.getConnection(
                    PotholeConfig.get("jdbc.url"),
                    PotholeConfig.get("jdbc.user"),
                    PotholeConfig.get("jdbc.password"));
        } catch (SQLException ex) {
            log.fatal("MySQL Connection Error -> " + ex.getMessage());
            throw new RuntimeException(ex);
        } catch (ClassNotFoundException ex) {
            log.fatal("JDBC Driver Error -> " + ex.getMessage());
            throw new RuntimeException(ex);
        }
    }

    private PreparedStatement prepare(String query, Object... args) throws SQLException {

        PreparedStatement stmt = conn.prepareStatement(query);
        int i = 1;
        for (Object o : args) {
            if (o == null) {
                stmt.setNull(i, 0);
            } else {
                String type = o.getClass().getName();

                switch (type) {
                    case "java.lang.String":
                        stmt.setString(i, (String) o);
                        break;
                    case "java.lang.Integer":
                        stmt.setInt(i, (Integer) o);
                        break;
                    case "java.lang.Double":
                        stmt.setDouble(i, (Double) o);
                        break;
                    case "java.lang.Long":
                        stmt.setLong(i, (Long) o);
                        break;
                    case "java.sql.Timestamp":
                        stmt.setTimestamp(i, (Timestamp) o);
                        break;
                    case "java.sql.Date":
                        stmt.setDate(i, (Date) o);
                        break;
                    default:
                        log.error("No such MySQL prepare type -> '" + type + "'");
                        throw new RuntimeException("No such MySQL prepare type -> " + type);
                }
            }
            i += 1;
        }
        return stmt;
    }

    protected ArrayList<HashMap> select(String query, Object... args) {

        ArrayList result = null;

        try (PreparedStatement stmt = prepare(query, args); ResultSet rs = stmt.executeQuery()) {
            result = resultSetToArrayList(rs);
        } catch (SQLException ex) {
            log.error("MySQL Error -> " + ex.getMessage(), ex);
            throw new RuntimeException("MySQL Error -> " + ex.getMessage());
        }

        return result;
    }

    protected int update(String query, Object... args) {

        int result = 0;
        try (PreparedStatement stmt = prepare(query, args)) {
            result = stmt.executeUpdate();
        } catch (SQLException ex) {
            log.error("MySQL Error -> " + ex.getMessage(), ex);
            throw new RuntimeException("MySQL Error -> " + ex.getMessage());
        }

        return result;
    }

    protected Object singleObject(String query, Object... args) {

        Object result = null;
        ArrayList<HashMap> queryResult = select(query, args);
        for (HashMap hm : queryResult) {
            for (Object key : hm.entrySet()) {
                result = hm.get(key);
            }
        }

        return result;
    }

    protected boolean rowExists(String query, Object... args) {

        return singleObject(query, args) != null;
    }

    private ArrayList<HashMap> resultSetToArrayList(ResultSet rs) throws SQLException {

        ResultSetMetaData md = rs.getMetaData();
        int columns = md.getColumnCount();
        ArrayList<HashMap> list = new ArrayList();
        while (rs.next()) {
            HashMap row = new HashMap(columns);
            for (int i = 1; i <= columns; ++i) {
                row.put(md.getColumnName(i), rs.getObject(i));
            }
            list.add(row);
        }

        return list;
    }

    public void close() {
        try {
            conn.close();
        } catch (SQLException ex) {
            log.error("Error closing DB connection -> " + ex.getMessage());
        }
    }
}
