package com.user.management.appl.facade.user.Impl;

import com.user.management.appl.facade.user.UserFacade;
import com.user.management.appl.facade.user.impl.UserFacadeImpl;
import com.user.management.appl.model.user.User;
import com.user.management.data.user.dao.UserDao;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
/**
 * This is the User Facade Impl Test.
 * */
class UserFacadeImplTest {

    @Mock
    private UserDao userDao;

    @Mock
    private User user;

    @InjectMocks
    private UserFacadeImpl userFacade;


    /**
     * Initializes mock objects and the UserFacadeImpl instance before each test.
     */
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        user.setId(1);
    }

    @AfterEach
    public void validate() {
        validateMockitoUsage();
    }

    // private UserDao userDAO = mock(UserDao.class);


    /**
     * Tests the getAllUsers method of UserFacadeImpl.
     *
     */
    @Test
    public void testGetAllUsers() {

        List<User> expectedUsers = new ArrayList<>();
        User user1 = new User();
        user1.setId(1);
        user1.setUsername("testUser1");
        expectedUsers.add(user1);

        when(userDao.getAllUsers()).thenReturn(expectedUsers);

        List<User> actualUsers = userFacade.getAllUsers();

        assertEquals(expectedUsers.size(), actualUsers.size());
    }

    @Test
    void checkUsername_Returns_User() {
        String username = "testUser";
        String password = "testPassword";
        String entityId = "entityId";
        Timestamp dateCreated = new Timestamp(new Date().getTime());
        Timestamp dateModified = new Timestamp(new Date().getTime());
        User expectedUser= new User(1, username, password, entityId, dateCreated, dateModified);

        UserDao mockUserDao = mock(UserDao.class);
        when(mockUserDao.findUserByUsername(username)).thenReturn(expectedUser);

        UserFacadeImpl UserFacade = new UserFacadeImpl(mockUserDao);

        User result = UserFacade.findUserByUsername(username);

        assertEquals(expectedUser, result);
        verify(mockUserDao, times(1)).findUserByUsername(username);
    }

    @Test
    void saveUser_Returns_Login() {
        String username = "penggu";
        String password = "Rk1234567!";
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

    @Test
    void testGetUserById() {
        when(userDao.getUserById(1)).thenReturn(user);
        User expectedUser = userFacade.getUserById(1);

        assert(expectedUser.equals(user));
        verify(userDao).getUserById(1);

    }

    @Test
    void testUpdateUser() {

        User userToUpdate = new User(1, "penggu", "Rk1234567!", "entity123", null, null);

        when(userDao.getUserById(userToUpdate.getId())).thenReturn(userToUpdate);

        when(userDao.updateUser()).thenReturn(true);

        boolean result = userFacade.updateUser(userToUpdate);
        assertTrue(result);
    }

    @Test
    public void testGetUsername() {
        when(userDao.getUsername("penggu")).thenReturn(user);
        User expectedUser = userFacade.getUsername("penggu");

        assert(expectedUser.equals(user));
        verify(userDao).getUsername("penggu");

    }

    @Test
    public void testUpdatePassword() {

        User testLogin = new User();
        testLogin.setId(1);
        testLogin.setUsername("penggu");
        testLogin.setPassword("Mk098765?");
        when(userDao.updatePassword(user)).thenReturn(testLogin);
        User expectedUser = userFacade.updatePassword(user);

        assert(expectedUser.equals(testLogin));
        verify(userDao).updatePassword(user);
    }

    @Test
    public void testForgotPasswordSuccessful() {

        UserDao userDAO = mock(UserDao.class);
        when(userDAO.getPasswordByUsername("penggu")).thenReturn("Rk1234567!");

        UserFacade passwordResetFacade = new UserFacadeImpl(userDAO);

        boolean result = passwordResetFacade.forgotPassword("penggu", "markian", "Mr098765?");

        assertTrue(result);
    }

    @Test
    public void testForgotPasswordIncorrectSecurityAnswer() {

        UserDao userDAO = mock(UserDao.class);
        when(userDAO.getPasswordByUsername("penggu")).thenReturn("RK1234567!");

        UserFacade passwordResetFacade = new UserFacadeImpl(userDAO);

        boolean result = passwordResetFacade.forgotPassword("penggu","pogi","Mk098765?");

        assertFalse(result);
    }
}