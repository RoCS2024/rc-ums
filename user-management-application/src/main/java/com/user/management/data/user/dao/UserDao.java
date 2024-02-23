/**
 * Data Access Object Interface
 * This serves as an interface named UserDao
 */

package com.user.management.data.user.dao;

import com.user.management.app.model.user.User;

public interface UserDao {
    User getUserById(int id);
    boolean addUser(User user);
    boolean updateUser(User user);
}
