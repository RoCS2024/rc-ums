package com.user.management.app.facade.user.Impl;

import com.user.management.app.facade.user.impl.UserFacadeImpl;
import com.user.management.app.model.user.User;
import com.user.management.data.user.dao.UserDao;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class UserFacadeImplTest {

    @Mock
    private UserDao mockUserDao;

    @InjectMocks
    private UserFacadeImpl userFacade;


    /**
     * Initializes mock objects and the UserFacadeImpl instance before each test.
     */
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * Tests the getAllUsers method of UserFacadeImpl.
     *
     */
    @Test
    public void testGetAllUsers() throws SQLException {

        List<User> expectedUsers = new ArrayList<>();
        User user1 = new User();
        user1.setId(1);
        user1.setUsername("testUser1");
        expectedUsers.add(user1);

        // Mocking UserDao behavior
        when(mockUserDao.getAllUsers()).thenReturn(expectedUsers);

        // Calling the method under test
        List<User> actualUsers = userFacade.getAllUsers();

        // Asserting the result
        assertEquals(expectedUsers.size(), actualUsers.size());
    }

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
