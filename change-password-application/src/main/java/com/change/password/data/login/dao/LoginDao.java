package com.change.password.data.login.dao;

import com.change.password.app.model.login.Login;

import java.sql.SQLException;
import java.util.List;

public interface LoginDao {

    Login getUsername(String username) throws SQLException;
    Login updatePassword(Login login) throws SQLException;

    List<Login> getUsername();

    Login updatePassword(String number);
}
