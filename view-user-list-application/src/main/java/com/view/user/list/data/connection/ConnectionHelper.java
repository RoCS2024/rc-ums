/**
 * The ConnectionHelper class provides methods for establishing a connection to the database.
 */
package com.view.user.list.data.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionHelper {
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:rogate";
    private static final String USER = "system";
    private static final String PASSWORD = "Changeme0";

    /**
     * Retrieves a connection to the database.
     *
     * @return A Connection object representing the database connection.
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

}
