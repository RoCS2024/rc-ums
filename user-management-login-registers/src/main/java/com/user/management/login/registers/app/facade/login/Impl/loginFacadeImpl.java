package com.user.management.login.registers.app.facade.login.Impl;

import com.user.management.login.registers.app.facade.login.loginFacade;
import com.user.management.login.registers.app.model.login.Login;
import com.user.management.login.registers.data.login.dao.impl.loginDaoImpl;
import com.user.management.login.registers.data.login.dao.loginDao;

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
    public Login saveUser(Login login) throws SQLException {
        return loginDao.saveUser(login);
    }
}
