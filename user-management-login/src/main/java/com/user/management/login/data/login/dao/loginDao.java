package com.user.management.login.data.login.dao;

import com.user.management.login.app.model.login.Login;

import java.sql.SQLException;

public interface loginDao {
    Login checkUsername(String username, String password) throws SQLException;
    void saveUser(Login login) throws SQLException;
    long getMaxUserId() throws SQLException;
}
