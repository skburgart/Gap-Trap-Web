package com.umd.pothole.database;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Steve
 */
public class DatabaseProperties {

    private static final Properties prop = new Properties();

    static {
        try {
            prop.load(new FileInputStream("database.properties"));
        } catch (IOException ex) {
            prop.setProperty("dbUrl", "jdbc:mysql://localhost/pothole");
            prop.setProperty("dbUser", "dashboardser");
            prop.setProperty("dbPassword", "dashboarduserpassword");

            try {
                prop.store(new FileOutputStream("database.properties"), "Database Properties");
            } catch (IOException ioex) {
                // nothing
            }
        }
    }

    public static String getProperty(String key) {
        return prop.getProperty(key);
    }
}