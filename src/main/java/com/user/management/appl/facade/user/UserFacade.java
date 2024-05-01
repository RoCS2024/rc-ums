package com.user.management.appl.facade.user;

import com.user.management.appl.model.user.User;

import java.util.List;
/**
 * This is the interface to the User Facade.
 * */
public interface UserFacade {


    /**
     * This finds a user by their username .
     *
     * @param username is the username of the user to find in the database.
     * @return username from database
     */
    User findUserByUsername(String username);



    /**
     *This saves a new user in the database.
     *
     * @param user is the user to be saved.
     * @return True if the user was successfully saved.
     */
    User saveUser(User user);


    /**
     * This retrieves all users in the database
     * @return list of users from the database
     */
    List<User> getAllUsers();

    /**
     * This gets a user from the database using their ID.
     * @param id is the ID of the user.
     * @return the user.
     */
    User getUserById(int id);

    /**
     * This updates a user information in the database.
     *
     * @param user is the user to update.
     * @return true if the updating of user information is successful.
     */
    boolean updateUser(User user);

    /**
     * This gets a user from the database using their username.
     * @param username is the username of the user.
     * @return the user.
     */
    User getUsername(String username);

    /**
     * This updates the password in the database.
     *
     * @param user is the employee to update.
     * @return true if the updating of password is successful.
     */
    User updatePassword(User user);

    /**
     * This handles the process of resetting a user's password.
     *
     * @param username is the username of the user .
     * @param securityQuestionAnswer is the answer to the security question.
     * @param newPassword is the new password to set for the user.
     * @return true if the password reset was successful, false otherwise.
     */
    boolean forgotPassword(String username, String securityQuestionAnswer, String newPassword);

}
