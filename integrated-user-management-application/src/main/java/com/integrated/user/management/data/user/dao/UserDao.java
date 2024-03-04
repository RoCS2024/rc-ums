package com.integrated.user.management.data.user.dao;

import com.integrated.user.management.app.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {

    /**
     * Retrieves a list of all users from the database.
     *
     */
    List<User> getAllUsers() throws SQLException;
}
