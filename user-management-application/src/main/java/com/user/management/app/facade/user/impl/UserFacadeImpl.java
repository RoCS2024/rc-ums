package com.user.management.app.facade.user.impl;

import com.user.management.app.facade.user.UserFacade;
import com.user.management.app.model.user.User;
import com.user.management.data.user.dao.UserDao;
import com.user.management.data.user.dao.impl.UserDaoImpl;

import java.sql.SQLException;
import java.util.List;

public class UserFacadeImpl implements UserFacade {
    private final UserDao userDao;

    public UserFacadeImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserFacadeImpl() {
        this.userDao = new UserDaoImpl();
    }

    @Override
    public User findUserByUsernameAndPassword(String username, String password) throws SQLException {
        return userDao.findUserByUsernameAndPassword(username, password);
    }

    @Override
    public User saveUser(User user) throws SQLException {
        return userDao.saveUser(user);
    }


    /**
     * Retrieves a list of all users from the database.
     * A List of User objects representing all users in the system.
     */
    @Override
    public List<User> getAllUsers() throws SQLException {
        return userDao.getAllUsers();
    }
    @Override
    public User getUserById(int id) { return userDao.getUserById(id);}

    @Override
    public boolean updateUser(User user) {
        boolean result = false;
        try {
            User targetUser = getUserById(user.getId());
            if(targetUser == null) {
                throw new Exception("User to update not found. ");
            }
            result = userDao.updateUser(user);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return result;
    }

    @Override
    public User getUsername(String username) throws SQLException {
        return userDao.getUsername(username);
    }

    @Override
    public User updatePassword(User login) throws SQLException {
        return userDao.updatePassword(login);
    }
}
