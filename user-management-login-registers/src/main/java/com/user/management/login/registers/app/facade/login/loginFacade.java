package com.user.management.login.registers.app.facade.login;

import com.user.management.login.registers.app.model.login.Login;

import java.sql.SQLException;

public interface loginFacade {
    Login checkUsername(String username, String password) throws SQLException;
    boolean registerUser(String username, String password) throws SQLException;
}