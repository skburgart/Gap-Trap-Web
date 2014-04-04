package com.umd.pothole.database;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.apache.log4j.Logger;

public class PotholeConfig {

    private static final Logger log = Logger.getLogger(PotholeConfig.class.getName());
    private static final Properties properties = loadProperties("pothole.properties");

    private static Properties loadProperties(String fileName) {

        Properties p = new Properties();
        try {
            InputStream is = PotholeConfig.class.getClassLoader().getResourceAsStream(fileName);
            p.load(is);
        } catch (IOException exp) {
            log.error("Unable to load pothole properties file", exp);
        }
        return p;
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}
