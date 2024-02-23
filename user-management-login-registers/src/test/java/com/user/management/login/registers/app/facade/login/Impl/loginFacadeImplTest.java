package com.user.management.login.registers.app.facade.login.Impl;

import com.user.management.login.registers.app.model.login.Login;
import com.user.management.login.registers.data.login.dao.loginDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class loginFacadeImplTest {

    private loginDao loginDao;
    private loginFacadeImpl loginFacade;

    @BeforeEach
    void setUp() {
        loginDao = mock(loginDao.class);
        loginFacade = new loginFacadeImpl(loginDao);
    }

    @Test
    void checkUsername_UserExists_ReturnsUser() throws SQLException {
        String username = "existingUser";
        String password = "password";
        Login existingUser = new Login();
        existingUser.setUsername(username);
        existingUser.setPassword(password);

        when(loginDao.checkUsername(username, password)).thenReturn(existingUser);

        Login retrievedUser = loginFacade.checkUsername(username, password);

        verify(loginDao, times(1)).checkUsername(username, password);
        assertEquals(existingUser, retrievedUser);
    }

    @Test
    void checkUsername_UserDoesNotExist_ReturnsNull() throws SQLException {
        String username = "nonExistingUser";
        String password = "password";

        when(loginDao.checkUsername(username, password)).thenReturn(null);

        Login retrievedUser = loginFacade.checkUsername(username, password);

        verify(loginDao, times(1)).checkUsername(username, password);
        assertNull(retrievedUser);
    }

    @Test
    void registerUser_NewUser_SuccessfullyRegistered() throws SQLException {
        String username = "newUser";
        String password = "password";
        Login newUser = new Login();
        newUser.setUsername(username);
        newUser.setPassword(password);

        when(loginDao.checkUsername(username, password)).thenReturn(null);

        when(loginDao.getMaxUserId()).thenReturn(100L);

        doNothing().when(loginDao).saveUser(any(Login.class));

        boolean isRegistered = loginFacade.registerUser(username, password);

        assertTrue(isRegistered);
        verify(loginDao, times(1)).checkUsername(username, password);
        verify(loginDao, times(1)).getMaxUserId();
        verify(loginDao, times(1)).saveUser(any(Login.class));
    }

    @Test
    void registerUser_ExistingUser_RegistrationFailed() throws SQLException {
        String username = "existingUser";
        String password = "password";

        when(loginDao.checkUsername(username, password)).thenReturn(new Login());

        boolean isRegistered = loginFacade.registerUser(username, password);

        assertFalse(isRegistered);
        verify(loginDao, times(1)).checkUsername(username, password);
        verify(loginDao, never()).getMaxUserId();
        verify(loginDao, never()).saveUser(any(Login.class));
    }
}
