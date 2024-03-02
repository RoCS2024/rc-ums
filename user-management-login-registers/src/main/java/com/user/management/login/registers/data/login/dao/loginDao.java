package com.user.management.login.registers.data.login.dao;

import com.user.management.login.registers.app.model.login.Login;

import java.sql.SQLException;

public interface loginDao {
    Login checkUsername(String username, String password) throws SQLException;
    Login saveUser(Login login) throws SQLException;
    long getMaxUserId() throws SQLException;
}
