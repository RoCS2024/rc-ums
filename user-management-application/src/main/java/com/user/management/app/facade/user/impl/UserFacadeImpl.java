package com.user.management.app.facade.user.impl;

import com.user.management.app.facade.user.UserFacade;
import com.user.management.app.model.user.User;
import com.user.management.data.user.dao.impl.UserDaoImpl;
import com.user.management.data.user.dao.UserDao;

import java.sql.SQLException;

public class UserFacadeImpl implements UserFacade {
    private final UserDao userDao;

    public UserFacadeImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserFacadeImpl() {
        this.userDao = new UserDaoImpl();
    }

    @Override
    public User checkUsername(String username, String password) throws SQLException {
        return userDao.checkUsername(username, password);
    }

    @Override
    public User saveUser(User login) throws SQLException {
        return userDao.saveUser(login);
    }
}
