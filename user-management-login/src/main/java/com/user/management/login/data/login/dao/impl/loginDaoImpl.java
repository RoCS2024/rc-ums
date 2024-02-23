package com.user.management.login.data.login.dao.impl;

import com.user.management.login.app.model.login.Login;
import com.user.management.login.data.connection.ConnectionHelper;
import com.user.management.login.data.login.dao.loginDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class loginDaoImpl implements loginDao {
    @Override
    public Login checkUsername(String username, String password) throws SQLException {
        String selectByIdQuery = "SELECT * FROM login WHERE username=?";
        Login login = null;

        try (Connection connection = ConnectionHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectByIdQuery)) {
            preparedStatement.setString(1, username);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    login = new Login();
                    login.setId(resultSet.getLong("id"));
                    login.setUsername(resultSet.getString("username"));
                    login.setPassword(resultSet.getString("password"));
                    login.setEntityId(resultSet.getString("entity_id"));
                    login.setDateCreated(resultSet.getTimestamp("date_created"));
                    login.setDateModified(resultSet.getTimestamp("date_modified"));
                }
            }
        }
        return login;
    }

    @Override
    public void saveUser(Login login) throws SQLException {
        String insertQuery = "INSERT INTO LOGIN (ID, USERNAME, PASSWORD, ENTITY_ID, DATE_CREATED, DATE_MODIFIED) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = ConnectionHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            preparedStatement.setLong(1, login.getId());
            preparedStatement.setString(2, login.getUsername());
            preparedStatement.setString(3, login.getPassword());
            preparedStatement.setString(4, login.getEntityId());
            preparedStatement.setTimestamp(5, login.getDateCreated());
            preparedStatement.setTimestamp(6, login.getDateModified());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public long getMaxUserId() throws SQLException {
        String selectMaxIdQuery = "SELECT MAX(ID) AS MAX_ID FROM LOGIN";
        try (Connection connection = ConnectionHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectMaxIdQuery);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                return resultSet.getLong("MAX_ID");
            }
        }
        return 0;
    }
}
