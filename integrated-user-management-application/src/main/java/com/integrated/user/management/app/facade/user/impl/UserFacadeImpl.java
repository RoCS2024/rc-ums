package com.integrated.user.management.app.facade.user.impl;

import com.integrated.user.management.app.facade.user.UserFacade;
import com.integrated.user.management.app.model.User;
import com.integrated.user.management.data.user.dao.UserDao;
import com.integrated.user.management.data.user.dao.impl.UserDaoImpl;

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
