/**
 * This serves as a class that implements the UserFacade.
 *
 */


package com.user.management.app.facade.user.impl;

import com.user.management.app.facade.user.UserFacade;
import com.user.management.app.model.user.User;
import com.user.management.data.user.dao.UserDao;
import com.user.management.data.user.dao.impl.UserDaoImpl;

public class UserFacadeImpl implements UserFacade {
    UserDao userDao = new UserDaoImpl();

    public UserFacadeImpl(UserDao userDao) {

    }

    @Override
    public User getUserById(int id) { return userDao.getUserById(id);}

    @Override
    public boolean updateUser(User user) {
        boolean result = false;
        try {
            User targetUser = getUserById(user.getId());
            if(targetUser == null) {
                throw new Exception("Customer to update not found. ");
            }
            result = userDao.updateUser(user);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return result;
    }
}
