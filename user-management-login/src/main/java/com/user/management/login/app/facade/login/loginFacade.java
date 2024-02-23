package com.user.management.login.app.facade.login;

import com.user.management.login.app.model.login.Login;

import java.sql.SQLException;

public interface loginFacade {
    Login checkUsername(String username, String password) throws SQLException;
    boolean registerUser(String username, String password) throws SQLException;
}