/**
 * The UserFacadeImpl class provides an implementation of the UserFacade interface.
 * It serves as a facade for user-related operations, providing methods to interact
 * with the underlying data access layer to retrieve user information.
 */
package com.view.user.list.app.facade.user.Impl;

import com.view.user.list.data.user.dao.UserDao;
import com.view.user.list.data.user.dao.Impl.UserDaoImpl;
import com.view.user.list.app.facade.user.UserFacade;
import com.view.user.list.app.model.user.User;
import java.sql.SQLException;
import java.util.List;

public class UserFacadeImpl implements UserFacade {

    private final UserDao userDao;

    /**
     * Constructs a new UserFacadeImpl object.
     * Initializes the UserDao instance to interact with the database.
     */
    public UserFacadeImpl() {

        this.userDao = new UserDaoImpl();
    }

    /**
     * Retrieves a list of all users from the database.
     * A List of User objects representing all users in the system.
     */
    @Override
    public List<User> getAllUsers() throws SQLException {
        return userDao.getAllUsers();
    }
}