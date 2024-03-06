package com.user.management.app.facade.user;

import com.user.management.app.model.user.User;

import java.sql.SQLException;
import java.util.List;

public interface UserFacade {
    User findUserByUsernameAndPassword(String username, String password) throws SQLException;
    User saveUser(User user) throws SQLException;


    /**
     * Retrieves a list of all users.
     *A List of User objects representing all users in the system.
     *
     */
    List<User> getAllUsers() throws SQLException;
}