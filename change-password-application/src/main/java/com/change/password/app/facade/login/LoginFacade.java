package com.change.password.app.facade.login;

import com.change.password.app.model.login.Login;

import java.sql.SQLException;

public interface LoginFacade {

    Login getUsername(String username) throws SQLException;
    Login updatePassword(Login login) throws SQLException;
}
