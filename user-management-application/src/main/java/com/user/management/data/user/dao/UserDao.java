package com.user.management.data.user.dao;

import com.user.management.app.model.user.User;

import java.sql.SQLException;

public interface UserDao {
    User findUserByUsernameAndPassword(String username, String password) throws SQLException;
    User saveUser(User user) throws SQLException;
    long getMaxUserId() throws SQLException;
}
