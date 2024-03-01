/**
 * This is a unit test for Facade Implementation.
 * */

package com.user.management.app.facade.user.impl;

import com.user.management.app.model.user.User;
import com.user.management.data.user.dao.UserDao;
import com.user.management.data.user.dao.impl.UserDaoImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserFacadeImplTest {
    private UserFacadeImpl userFacade;
    private UserDao userDao;

    @BeforeEach
    void setUp() {
        userDao = mock(UserDaoImpl.class);
        userFacade = new UserFacadeImpl(userDao);
    }

    @Test
    void testGetUserById() {
        // Mock behavior of userDao.getUserById(id) method
        int userId = 1;
        User mockedUser = new User(userId, "testuser", "testpassword", "entity123", null, null);
        when(userDao.getUserById(userId)).thenReturn(mockedUser);

        // Test getUserById method of UserFacadeImpl
        User resultUser = userFacade.getUserById(userId);
        assertEquals(mockedUser, resultUser);
    }

    @Test
    void testUpdateUser() {
        // Prepare test data
        User userToUpdate = new User(1, "testuser", "testpassword", "entity123", null, null);

        // Mock behavior of userDao.getUserById(id) method
        when(userDao.getUserById(userToUpdate.getId())).thenReturn(userToUpdate);

        // Mock behavior of userDao.updateUser(user) method
        when(userDao.updateUser(userToUpdate)).thenReturn(true);

        // Test updateUser method of UserFacadeImpl
        boolean result = userFacade.updateUser(userToUpdate);
        assertTrue(result);
    }
}