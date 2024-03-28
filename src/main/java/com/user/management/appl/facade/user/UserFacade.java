package com.user.management.appl.facade.user;

import com.user.management.appl.model.user.User;

import java.sql.SQLException;
import java.util.List;
/**
 * This is the User Facade.
 * */
public interface UserFacade {
    User findUserByUsername(String username);
    User saveUser(User user) throws SQLException;


    /**
     * Retrieves a list of all users.
     *A List of User objects representing all users in the system.
     *
     */
    List<User> getAllUsers();
    User getUserById(int id);
    boolean updateUser(User user);
    User getUsername(String username);
    User updatePassword(User user);

    boolean forgotPassword(String username, String securityQuestionAnswer, String newPassword);

}