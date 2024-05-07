package com.user.management.appl.facade.user.impl;

import com.user.management.appl.facade.user.UserFacade;
import com.user.management.appl.model.user.User;
import com.user.management.data.user.dao.UserDao;
import com.user.management.data.user.dao.impl.UserDaoImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * This is the implementation class for the UserFacade
 */
public class UserFacadeImpl implements UserFacade {

    public static final Logger LOGGER = LoggerFactory.getLogger(UserFacadeImpl.class);

    private UserDao userDao;

    private User[] userList;

    /**
     * Constructs a new UserFacadeImpl with the UserDao.
     * @param userDao The data access object for user operations.
     */
    public UserFacadeImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User findUserByUsername(String username) {
        return userDao.findUserByUsername(username);
    }

    @Override
    public User saveUser(User user) {
        return userDao.saveUser(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    @Override
    public boolean updateUser(User user) {
        boolean result = false;
        try {
            User targetUser = getUserById(user.getId());
            if(targetUser == null) {
                LOGGER.debug("User to update not found.");
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

    @Override
    public boolean forgotPassword(String username, String securityQuestionAnswer, String newPassword) {
        String getPassword = userDao.getPasswordByUsername(username);
        if(getPassword != null){
            if(securityQuestionAnswer.equalsIgnoreCase("markian")){
                userDao.forgotPassword(username,newPassword);
                return true;
            }
        }
        return false;
    }
}
