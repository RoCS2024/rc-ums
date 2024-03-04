package com.integrated.user.management.data.user.dao.impl;

import com.integrated.user.management.app.model.User;
import com.integrated.user.management.data.connection.ConnectionHelper;
import com.integrated.user.management.data.user.dao.UserDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.integrated.user.management.data.utils.QueryConstant.GET_ALL_CUSTOMERS_STATEMENT;

public class UserDaoImpl implements UserDao {

    /**
     * Retrieves a list of all users from the database.
     * A List of User objects representing all users in the system.
     *
     */
    @Override
    public List<User> getAllUsers() throws SQLException {
        List<User> userList = new ArrayList<>();
        String query = GET_ALL_CUSTOMERS_STATEMENT;

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
