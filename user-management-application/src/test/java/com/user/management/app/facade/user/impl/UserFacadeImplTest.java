/**
 * This is a unit test for Facade Implementation.
 * */

package com.user.management.app.facade.user.impl;

import com.user.management.app.model.user.User;
import com.user.management.data.user.dao.UserDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserFacadeImplTest {
    @Mock
    UserDao userDao;

    UserFacadeImpl userFacade;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        userFacade = new UserFacadeImpl(userDao);
    }

    @Test
    void addUser_shouldReturnTrue_whenUserNotExistsAndAddedSuccessfully() {
        User newUser = new User(1, "john_doe", "password123", "entity123", null, null);
        when(userDao.getUserById(1)).thenReturn(null);
        when(userDao.addUser(newUser)).thenReturn(true);
        boolean result = userFacade.addUser(newUser);
        verify(userDao).getUserById(1);
        verify(userDao).addUser(newUser);
        assertTrue(result);
    }

    @Test
    void addUser_shouldThrowRuntimeException_whenUserExists() {
        User existingUser = new User(1, "john_doe", "password123", "entity123", null, null);
        when(userDao.getUserById(1)).thenReturn(existingUser);
        assertThrows(RuntimeException.class, () -> userFacade.addUser(existingUser));
        verify(userDao).getUserById(1);
        verify(userDao, never()).addUser(existingUser);
    }

    @Test
    void updateUser_shouldReturnTrue_whenUserExistsAndUpdateSuccessful() {
        User existingUser = new User(1, "john_doe", "password123", "entity123", null, null);
        when(userDao.getUserById(1)).thenReturn(existingUser);
        when(userDao.updateUser(existingUser)).thenReturn(true);
        boolean result = userFacade.updateUser(existingUser);
        verify(userDao).getUserById(1);
        verify(userDao).updateUser(existingUser);
        assertTrue(result);
    }

    @Test
    void updateUser_shouldThrowRuntimeException_whenUserDoesNotExist() {
        User nonExistingUser = new User(999, "non_existing_user", "password456", "entity456", null, null);
        when(userDao.getUserById(999)).thenReturn(null);
        assertThrows(RuntimeException.class, () -> userFacade.updateUser(nonExistingUser));
        verify(userDao).getUserById(999);
        verify(userDao, never()).updateUser(nonExistingUser);
    }

}