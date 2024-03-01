package com.change.password.data.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionHelper {
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:rogate";
    public static final String ORACLE_DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String USER = "system";
    private static final String PASSWORD = "Changeme0";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void rollbackTransaction(SQLException e) {
    }

    public static void setConnection(Connection connection) {
    }
}