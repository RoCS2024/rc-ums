package com.user.management.data.user.dao.impl;

import com.user.management.app.model.user.User;
import com.user.management.data.connection.ConnectionHelper;
import com.user.management.data.user.dao.UserDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    @Override
    public User checkUsername(String username, String password) throws SQLException {
        String selectByIdQuery = "SELECT * FROM login WHERE username=?";
        User User = null;

        try (Connection connection = ConnectionHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectByIdQuery)) {
            preparedStatement.setString(1, username);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    User = new User();
                    User.setId((int) resultSet.getLong("id"));
                    User.setUsername(resultSet.getString("username"));
                    User.setPassword(resultSet.getString("password"));
                    User.setEntity_id(resultSet.getString("entity_id"));
                    User.setDate_created(resultSet.getTimestamp("date_created"));
                    User.setDate_modified(resultSet.getTimestamp("date_modified"));
                }
            }
        }
        return User;
    }

    @Override
    public User saveUser(User User) throws SQLException {
        String insertQuery = "INSERT INTO login (ID, USERNAME, PASSWORD, ENTITY_ID, DATE_CREATED, DATE_MODIFIED) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = ConnectionHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            long MaxId = getMaxUserId();

            preparedStatement.setLong(1, MaxId + 1);
            preparedStatement.setString(2, User.getUsername());
            preparedStatement.setString(3, User.getPassword());
            preparedStatement.setString(4, User.getEntity_id());
            preparedStatement.setTimestamp(5, User.getDate_created());
            preparedStatement.setTimestamp(6, User.getDate_modified());
            preparedStatement.executeUpdate();
        }
        return User;
    }

    @Override
    public long getMaxUserId() throws SQLException {
        String selectMaxIdQuery = "SELECT MAX(ID) AS MAX_ID FROM login";
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
