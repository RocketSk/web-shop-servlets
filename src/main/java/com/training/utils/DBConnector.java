package com.training.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public final class DBConnector {
    private static final String DB_PROPERTIES_PATH = "db/db.properties";
    private static final String DB_URL = "db.URL";
    private static final String DB_USERNAME = "db.username";
    private static final String DB_PASSWORD = "db.password";
    private static final Logger LOGGER = LogManager.getLogger(DBConnector.class.getName());
    private static Connection connection;

    static {
        Properties properties = new Properties();
        InputStream inputProperties = Thread.currentThread().getContextClassLoader().getResourceAsStream(DB_PROPERTIES_PATH);
        if (inputProperties != null) {
            try {
                properties.load(inputProperties);
                inputProperties.close();
            } catch (IOException e) {
                LOGGER.error("Can't read the properties file,\n" +
                        "please, check the file path" + DB_PROPERTIES_PATH + "\n" + e);
            }
        }
        try {
            String url = properties.getProperty(DB_URL);
            String username = properties.getProperty(DB_USERNAME);
            String password = properties.getProperty(DB_PASSWORD);
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            LOGGER.error("Connection with database failure.\n" + e);
        }
    }

    private DBConnector() {

    }

    public static Connection getConnection() {
        return connection;
    }
}
