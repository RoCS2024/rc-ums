package com.user.management.app.facade.user.Impl;

import com.user.management.app.facade.user.impl.UserFacadeImpl;
import com.user.management.app.model.user.User;
import com.user.management.data.user.dao.UserDao;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class UserFacadeImplTest {

    @Test
    void checkUsername_Returns_User() throws SQLException {
        String username = "testUser";
        String password = "testPassword";
        String entityId = "entityId";
        Timestamp dateCreated = new Timestamp(new Date().getTime());
        Timestamp dateModified = new Timestamp(new Date().getTime());
        User expectedUser= new User(1, username, password, entityId, dateCreated, dateModified);

        UserDao mockUserDao = mock(UserDao.class);
        when(mockUserDao.findUserByUsernameAndPassword(username, password)).thenReturn(expectedUser);

        UserFacadeImpl UserFacade = new UserFacadeImpl(mockUserDao);

        User result = UserFacade.findUserByUsernameAndPassword(username, password);

        assertEquals(expectedUser, result);
        verify(mockUserDao, times(1)).findUserByUsernameAndPassword(username, password);
    }

    @Test
    void saveUser_Returns_Login() throws SQLException {
        String username = "testUser";
        String password = "testPassword";
        String entityId = "entityId";
        Timestamp dateCreated = new Timestamp(new Date().getTime());
        Timestamp dateModified = new Timestamp(new Date().getTime());
        User user = new User(1, username, password, entityId, dateCreated, dateModified);
        User expectedSavedUser = new User(1, username, password, entityId, dateCreated, dateModified);

        UserDao mockUserDao = mock(UserDao.class);
        when(mockUserDao.saveUser(user)).thenReturn(expectedSavedUser);

        UserFacadeImpl UserFacade = new UserFacadeImpl(mockUserDao);

        User result = UserFacade.saveUser(user);

        assertEquals(expectedSavedUser, result);
        verify(mockUserDao, times(1)).saveUser(user);
    }
}
