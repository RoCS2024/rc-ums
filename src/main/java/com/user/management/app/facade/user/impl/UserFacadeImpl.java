package com.user.management.app.facade.user.impl;

import com.user.management.app.facade.user.UserFacade;
import com.user.management.app.model.user.User;
import com.user.management.data.user.dao.UserDao;
import com.user.management.data.user.dao.impl.UserDaoImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the User Facade Impl.
 * */
public class UserFacadeImpl implements UserFacade {

    public static final Logger LOGGER = LoggerFactory.getLogger(UserFacadeImpl.class);

    private final UserDao userDao;

    private User[] userList;

    public UserFacadeImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserFacadeImpl() {
        this.userDao = new UserDaoImpl();
    }

    public void UserFacade() {this.userList = new ArrayList<>().toArray(new User[0]);}

    @Override
    public User findUserByUsername(String username) {
        return userDao.findUserByUsername(username);
    }


    @Override
    public User saveUser(User user) {
        return userDao.saveUser(user);
    }
    /**
     * Retrieves a list of all users from the database.
     * A List of User objects representing all users in the system.
     */
    @Override
    public List<User> getAllUsers() {
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
                LOGGER.debug("User to update not found. ");

            }
            result = userDao.updateUser();

        } catch (Exception e) {
            LOGGER.error("An SQL Exception occurred." + e.getMessage());

        }
        LOGGER.debug("Updating user failed.");
        return result;
    }

    @Override
    public User getUsername(String username) {

        return userDao.getUsername(username);
    }

    @Override
    public User updatePassword(User user) {
        return userDao.updatePassword(user);
    }
}
