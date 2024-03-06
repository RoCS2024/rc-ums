package com.user.management.app.facade.user;

import com.user.management.app.model.user.User;

import java.sql.SQLException;

public interface UserFacade {
    User checkUsername(String username, String password) throws SQLException;
    User saveUser(User user) throws SQLException;
}