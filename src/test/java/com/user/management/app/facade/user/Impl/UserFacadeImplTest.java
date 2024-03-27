package java.com.user.management.app.facade.user.Impl;

import com.user.management.app.facade.user.impl.UserFacadeImpl;
import com.user.management.app.model.user.User;
import com.user.management.data.user.dao.UserDao;

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
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
/**
 * This is the User Facade Impl Test.
 * */
class UserFacadeImplTest {

//    @Mock
//    private UserDao mockUserDao;

//    @InjectMocks
//    private UserFacadeImpl userFacade;


//    /**
//     * Initializes mock objects and the UserFacadeImpl instance before each test.
//     */
//    @BeforeEach
//    public void setUp() {
//        MockitoAnnotations.initMocks(this);
//    }


//    private UserDao userDao;

//    /**
//     * Tests the getAllUsers method of UserFacadeImpl.
//     *
//     */
//    @Test
//    public void testGetAllUsers() {

//        List<User> expectedUsers = new ArrayList<>();
//        User user1 = new User();
//        user1.setId(1);
//        user1.setUsername("testUser1");
//        expectedUsers.add(user1);

//        when(mockUserDao.getAllUsers()).thenReturn(expectedUsers);

//        List<User> actualUsers = userFacade.getAllUsers();

//        assertEquals(expectedUsers.size(), actualUsers.size());
//    }

//    @Test
//    void checkUsername_Returns_User() {
//        String username = "testUser";
//       String password = "testPassword";
//        String entityId = "entityId";
//        Timestamp dateCreated = new Timestamp(new Date().getTime());
//        Timestamp dateModified = new Timestamp(new Date().getTime());
//        User expectedUser= new User(1, username, password, entityId, dateCreated, dateModified);

//        UserDao mockUserDao = mock(UserDao.class);
//        when(mockUserDao.findUserByUsernameAndPassword(username, password)).thenReturn(expectedUser);

//        UserFacadeImpl UserFacade = new UserFacadeImpl(mockUserDao);

//        User result = UserFacade.findUserByUsernameAndPassword(username, password);

//        assertEquals(expectedUser, result);
//        verify(mockUserDao, times(1)).findUserByUsernameAndPassword(username, password);
//    }

//    @Test
//    void saveUser_Returns_Login() {
//        String username = "testUser";
//        String password = "testPassword";
//        String entityId = "entityId";
//        Timestamp dateCreated = new Timestamp(new Date().getTime());
//        Timestamp dateModified = new Timestamp(new Date().getTime());
//        User user = new User(1, username, password, entityId, dateCreated, dateModified);
//        User expectedSavedUser = new User(1, username, password, entityId, dateCreated, dateModified);

//        UserDao mockUserDao = mock(UserDao.class);
//        when(mockUserDao.saveUser(user)).thenReturn(expectedSavedUser);

//        UserFacadeImpl UserFacade = new UserFacadeImpl(mockUserDao);

//        User result = UserFacade.saveUser(user);

//        assertEquals(expectedSavedUser, result);
//        verify(mockUserDao, times(1)).saveUser(user);
//    }

//    @Test
//    void testGetUserById() {
//        int userId = 1;
//        User mockedUser = new User(userId, "testuser", "testpassword", "entity123", null, null);
//        when(userDao.getUserById(userId)).thenReturn(mockedUser);

//        User resultUser = userFacade.getUserById(userId);
//        assertEquals(mockedUser, resultUser);
//    }

//    @Test
//    void testUpdateUser() {

//        User userToUpdate = new User(1, "testuser", "testpassword", "entity123", null, null);

//        when(userDao.getUserById(userToUpdate.getId())).thenReturn(userToUpdate);

//        when(userDao.updateUser()).thenReturn(true);

//        boolean result = userFacade.updateUser(userToUpdate);
//        assertTrue(result);
//    }

//    @Test
//    public void testGetUsername(String username) {

//        User testLogin = new User();
//        testLogin.setId(1);
//        testLogin.setUsername("testuser");
//        testLogin.setPassword("testpassword");

//        when(userDao.getUsername(username)).thenReturn(testLogin);

//        User result = userFacade.getUsername("testuser");

//        assertEquals(testLogin, result);
//    }

//    @Test
//    public void testUpdatePassword(User user) {

//        User testLogin = new User();
//        testLogin.setUsername("testuser");
//        testLogin.setPassword("newpassword");

//        when(userDao.updatePassword(user)).thenReturn(testLogin);

//        User result = userFacade.updatePassword(testLogin);

//        assertEquals(testLogin, result);
//    }

   // @Test
   // public void testForgotPassword(User user) {

        //User testLogin = new User();
        //testLogin.setUsername("testuser");
       // testLogin.setPassword("newpassword");

       // when(userDao.updatePassword(user)).thenReturn(testLogin);

       // User result = userFacade.updatePassword(testLogin);

       // assertEquals(testLogin, result);
    }
}
