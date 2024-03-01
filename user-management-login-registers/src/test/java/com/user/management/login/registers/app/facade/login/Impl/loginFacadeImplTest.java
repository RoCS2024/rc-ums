package com.user.management.login.registers.app.facade.login.Impl;

import com.user.management.login.registers.app.model.login.Login;
import com.user.management.login.registers.data.login.dao.loginDao;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class loginFacadeImplTest {

    @Test
    void checkUsername_Returns_Login() throws SQLException {
        // Arrange
        String username = "testUser";
        String password = "testPassword";
        String entityId = "entityId";
        Timestamp dateCreated = new Timestamp(new Date().getTime());
        Timestamp dateModified = new Timestamp(new Date().getTime());
        Login expectedLogin = new Login(1, username, password, entityId, dateCreated, dateModified);

        loginDao mockLoginDao = mock(loginDao.class);
        when(mockLoginDao.checkUsername(username, password)).thenReturn(expectedLogin);

        loginFacadeImpl loginFacade = new loginFacadeImpl(mockLoginDao);

        // Act
        Login result = loginFacade.checkUsername(username, password);

        // Assert
        assertEquals(expectedLogin, result);
        verify(mockLoginDao, times(1)).checkUsername(username, password);
    }

    @Test
    void saveUser_Returns_Login() throws SQLException {
        // Arrange
        String username = "testUser";
        String password = "testPassword";
        String entityId = "entityId";
        Timestamp dateCreated = new Timestamp(new Date().getTime());
        Timestamp dateModified = new Timestamp(new Date().getTime());
        Login login = new Login(1, username, password, entityId, dateCreated, dateModified);
        Login expectedSavedLogin = new Login(1, username, password, entityId, dateCreated, dateModified);

        loginDao mockLoginDao = mock(loginDao.class);
        when(mockLoginDao.saveUser(login)).thenReturn(expectedSavedLogin);

        loginFacadeImpl loginFacade = new loginFacadeImpl(mockLoginDao);

        // Act
        Login result = loginFacade.saveUser(login);

        // Assert
        assertEquals(expectedSavedLogin, result);
        verify(mockLoginDao, times(1)).saveUser(login);
    }
}
