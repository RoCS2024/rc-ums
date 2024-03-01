/**
 * This is a connection helper class.
 * this class is responsible in establishing a connection with the database.
 * this connection helper is connected to an Oracle Database.
 * */

package com.user.management.data.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionHelper {
    public static final String URL = "jdbc:oracle:thin:@localhost:1521:rogate"; //SSID na gamit, instance ng database
    public static final String ORACLE_DRIVER = "oracle.jdbc.driver.OracleDriver";
    public static final String username = "system"; //username
    public static final String password = "Changeme0"; //password

    public static Connection getConnection()
    {
        try {
            Class.forName(ORACLE_DRIVER); //Class.forName(ORACLE_DRIVER).newInstance();
            return DriverManager.getConnection(URL, username, password);
        } catch (Exception ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        }
    }
}
