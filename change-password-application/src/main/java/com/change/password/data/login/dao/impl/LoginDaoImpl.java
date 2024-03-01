package com.change.password.data.login.dao.impl;

import com.change.password.app.model.login.Login;
import com.change.password.data.connection.ConnectionHelper;
import com.change.password.data.login.dao.LoginDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class LoginDaoImpl implements LoginDao {

    public static void setConnectionHelper(ConnectionHelper connectionHelper) {
    }

    @Override
    public Login getUsername(String username) throws SQLException {
        String selectUsernameQuery = "SELECT * FROM login WHERE username=?";
        Login login = null;
        try (Connection connection = ConnectionHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectUsernameQuery)) {

            preparedStatement.setString(1, username);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    login = new Login();
                    login.setId(resultSet.getInt("id"));
                    login.setUsername(resultSet.getString("username"));
                    login.setPassword(resultSet.getString("password"));
                }
            }
        }
        return login;
    }

    @Override
    public Login updatePassword(Login login) throws SQLException {
        String updateQuery = "UPDATE login SET password=?, date_modified=? WHERE username=?";
        try (Connection connection = ConnectionHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {

                preparedStatement.setString(1, login.getPassword());
                preparedStatement.setTimestamp(2, login.getDateModified());
                preparedStatement.setString(3, login.getUsername());
            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Password update failed.");
            }
        }
        return login;
    }
}
