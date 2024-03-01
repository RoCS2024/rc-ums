package com.change.password.app.facade.login.impl;

import com.change.password.app.model.login.Login;
import com.change.password.data.login.dao.LoginDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class LoginFacadeImplTest {
    private LoginDao loginDaoMock;
    private LoginFacadeImpl loginFacade;

    @BeforeEach
    public void setUp() {
        loginDaoMock = mock(LoginDao.class);
        loginFacade = new LoginFacadeImpl(loginDaoMock);
    }

    @Test
    public void testGetUsername() throws SQLException {

        Login testLogin = new Login();
        testLogin.setId(1);
        testLogin.setUsername("testuser");
        testLogin.setPassword("testpassword");

        when(loginDaoMock.getUsername(anyString())).thenReturn(testLogin);

        Login result = loginFacade.getUsername("testuser");

        assertEquals(testLogin, result);
    }

    @Test
    public void testUpdatePassword() throws SQLException {

        Login testLogin = new Login();
        testLogin.setUsername("testuser");
        testLogin.setPassword("newpassword");

        when(loginDaoMock.updatePassword(testLogin)).thenReturn(testLogin);

        Login result = loginFacade.updatePassword(testLogin);

        assertEquals(testLogin, result);
    }
}