package com.integrated.user.management.app.facade.user;

import com.integrated.user.management.app.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserFacade {

    /**
     * Retrieves a list of all users.
     *A List of User objects representing all users in the system.
     *
     */
    List<User> getAllUsers() throws SQLException;
}
