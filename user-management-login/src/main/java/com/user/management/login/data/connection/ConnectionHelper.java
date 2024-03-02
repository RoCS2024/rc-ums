package com.user.management.login.data.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionHelper {
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:rcian";
    private static final String USER = "system";
    private static final String PASSWORD = "Changeme0";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void rollbackTransaction(SQLException e) {
    }
}