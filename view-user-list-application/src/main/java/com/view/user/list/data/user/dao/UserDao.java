/**
 * The UserDao interface defines methods for accessing user data from the database.
 */
package com.view.user.list.data.user.dao;

import java.sql.Connection;
import java.sql.SQLException;
import com.view.user.list.app.model.user.User;
import java.util.List;

public interface UserDao {

    /**
     * Retrieves a list of all users from the database.
     *
     */
    List<User> getAllUsers() throws SQLException;
}

