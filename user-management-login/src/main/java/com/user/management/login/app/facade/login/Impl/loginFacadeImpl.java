package com.user.management.login.app.facade.login.Impl;

import com.user.management.login.app.facade.login.loginFacade;
import com.user.management.login.app.model.login.Login;
import com.user.management.login.data.login.dao.loginDao;
import com.user.management.login.data.login.dao.impl.loginDaoImpl;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
public class loginFacadeImpl implements loginFacade {
    private final loginDao loginDao;

    public loginFacadeImpl(loginDao loginDao) {
        this.loginDao = loginDao;
    }

    public loginFacadeImpl() {
        this.loginDao = new loginDaoImpl();
    }

    @Override
    public Login checkUsername(String username, String password) throws SQLException {
        return loginDao.checkUsername(username, password);
    }

    @Override
    public boolean registerUser(String username, String password) throws SQLException {
        Login existingUser = loginDao.checkUsername(username, password);
        if (existingUser != null) {
            System.out.println("Username already exists. Registration failed.");
            return false;
        }

        Login newUser = new Login();
        long nextId = getNextUserId();
        newUser.setId(nextId);
        newUser.setUsername(username);
        newUser.setPassword(password);
        Timestamp currentTimestamp = new Timestamp(new Date().getTime());
        newUser.setDateCreated(currentTimestamp);
        newUser.setDateModified(currentTimestamp);
        loginDao.saveUser(newUser);

        return true;
    }

    private long getNextUserId() throws SQLException {
        long maxId = loginDao.getMaxUserId();
        return maxId + 1;
    }
}
