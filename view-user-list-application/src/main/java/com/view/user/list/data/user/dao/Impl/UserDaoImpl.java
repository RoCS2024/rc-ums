/**
 * The UserDaoImpl class provides an implementation of the UserDao interface.
 * It facilitates the retrieval of user data from the database.
 */
package com.view.user.list.data.user.dao.Impl;

import com.view.user.list.data.user.dao.UserDao;
import com.view.user.list.app.model.user.User;
import com.view.user.list.data.connection.ConnectionHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    /**
     * Retrieves a list of all users from the database.
     * A List of User objects representing all users in the system.
     *
     */
    @Override
    public List<User> getAllUsers() throws SQLException {
        List<User> userList = new ArrayList<>();
        String query = "SELECT * FROM LOGIN";

        try (Connection connection = ConnectionHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                User user = new User();
                user.setUserId(resultSet.getInt("ID"));
                user.setUserName(resultSet.getString("USERNAME"));
                user.setPassword(resultSet.getString("PASSWORD"));
                user.setEntityId(resultSet.getString("ENTITY_ID"));
                user.setDateCreated(resultSet.getTimestamp("DATE_CREATED"));
                user.setDateModified(resultSet.getTimestamp("DATE_MODIFIED"));
                userList.add(user);
            }
        }

        return userList;
    }
}