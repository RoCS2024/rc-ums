package com.change.password.app.facade.login.impl;

import com.change.password.app.facade.login.LoginFacade;
import com.change.password.app.model.login.Login;
import com.change.password.data.login.dao.LoginDao;
import com.change.password.data.login.dao.impl.LoginDaoImpl;

import java.sql.SQLException;
import java.util.List;

public class LoginFacadeImpl implements LoginFacade {
    private final LoginDao loginDao;
    public LoginFacadeImpl(LoginDao loginDao) { this.loginDao = loginDao; }
    public LoginFacadeImpl() {this.loginDao = new LoginDaoImpl() {
        @Override
        public List<Login> getUsername() {
            return null;
        }

        @Override
        public Login updatePassword(String number) {
            return null;
        }
    };
    }

    @Override
    public Login getUsername(String username) throws SQLException {
        return loginDao.getUsername(username);
    }

    @Override
    public Login updatePassword(Login login) throws SQLException {
        return loginDao.updatePassword(login);
    }
}
