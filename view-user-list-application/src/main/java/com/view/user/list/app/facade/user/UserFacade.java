/**
 * The UserFacade interface defines methods for interacting with user-related operations.
 * Implementations of this interface provide functionality to retrieve user information
 * from the underlying data access layer.
 */

package com.view.user.list.app.facade.user;


import com.view.user.list.app.model.user.User;
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