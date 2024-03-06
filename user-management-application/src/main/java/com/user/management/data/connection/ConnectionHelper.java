package com.user.management.data.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionHelper {
    public static final String URL = "jdbc:oracle:thin:@localhost:1521:baemonville";
    public static final String ORACLE_DRIVER = "oracle.jdbc.driver.OracleDriver";
    public static final String username = "system";
    public static final String password = "J03J16R11L27";

    public static Connection getConnection() throws RuntimeException {
        try {
            Class.forName(ORACLE_DRIVER).newInstance();
            return DriverManager.getConnection(URL, username, password);
        } catch (Exception ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        }
    }
}
