package com.user.management.data.user.dao.impl;

import com.user.management.appl.model.student.Student;
import com.user.management.appl.model.user.User;
import com.user.management.data.user.dao.UserDao;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * This is the User Dao Impl Test.
 * */
class UserDaoImplTest {

    private UserDao userDao;
    private List<User> users;

    @BeforeEach
    public void setUp() {
        users = new ArrayList<>();
        User user1 = new User();
        User user2 = new User();
        users.add(user1);
        users.add(user2);

        userDao = mock(UserDao.class);
    }
    @Test
    public void testGetAllUsers() {
       when(userDao.getAllUsers()).thenReturn(users);
       List<User> userList = userDao.getAllUsers();
       assertEquals(userList.size(), 2);
    }
    @Test
    public void testGetUsername() {
        User user1 = new User();
        user1.setUsername("Amulong");

        UserDao userDao = Mockito.mock(UserDao.class);

        Mockito.when(userDao.getUsername("Amulong")).thenReturn(user1);

        User expectedUser = userDao.getUsername("Amulong");
        assertEquals("Amulong", expectedUser.getUsername());
    }
    @Test
    public void testSaveUser(){
        User user1 = new User();
        user1.setId(1);


        when(userDao.saveUser(user1)).thenReturn(user1);
        User expectedUser = userDao.saveUser(user1);

        verify(userDao).saveUser(user1);

        assertEquals(expectedUser, user1);
        assertEquals(expectedUser.getId(), user1.getId());
    }
    @Test
    public void testFindUserByUsername(){
        User user1 = new User();
        user1.getId();

        when(userDao.findUserByUsername("Amulong")).thenReturn(user1);

        User expectedUser = userDao.findUserByUsername("Amulong");

        assertEquals(expectedUser, user1);
        assertEquals(expectedUser.getId(), user1.getId());
    }
    @Test
    public void getMaxUserId() {
        User user1 = new User();
        user1.setId(1);

        Mockito.when(userDao.getMaxUserId()).thenReturn((long) user1.getId());

        long expectedUserId = userDao.getMaxUserId();

        assertEquals(expectedUserId, user1.getId());

    }

    @Test
    public void testGetUserById() {
       User user1 = new User();
       user1.setId(1);

       when(userDao.getUserById(1)).thenReturn(user1);

       User expectedUser = userDao.getUserById(1);

       assertEquals(expectedUser, user1);
       assertEquals(expectedUser.getId(), user1.getId());
    }


    @Test
    void testUpdateUser()  {
       User user = new User();
       user.setId(1);
       user.setUsername("Amulong");
;
       when(userDao.updateUser()).thenReturn(true);
       when(userDao.getUserById(1)).thenReturn(user);

       User expectedUser = userDao.getUserById(1);
       assertEquals(expectedUser.getUsername(), user.getUsername());
    }
    @Test
    public void testUpdatePassword() {
        User user = new User();
        user.setPassword("CT21-0073");
        when(userDao.saveUser(user)).thenReturn(user);
        when(userDao.updatePassword(user)).thenReturn(user);

        when(userDao.getPasswordByUsername("CT21-0073")).thenReturn("CT21-0073");

        String expectedPassword = userDao.getPasswordByUsername("CT21-0073");

        assertFalse(expectedPassword.isEmpty());

        assertEquals("CT21-0073", expectedPassword);
    }

   @Test
   public void testGetPasswordByUsername() {
       User user1 = new User();
       user1.setUsername("Amulong");
       user1.setPassword("password123");

       UserDao userDao = Mockito.mock(UserDao.class);

       Mockito.when(userDao.getUsername("Amulong")).thenReturn(user1);
       Mockito.when(userDao.getPasswordByUsername("Amulong")).thenReturn(null);

       String password = userDao.getPasswordByUsername("Amulong");
       assertNull(password);
    }

   @Test
   void testForgotPassword() {
      Connection connection = mock(Connection.class);
      PreparedStatement preparedStatement = mock(PreparedStatement.class);

      try {

         UserDao userDAO = new UserDaoImpl();

         String result = userDAO.forgotPassword("penggu", "Mr098765?");

         assertNull(result);

      } catch (Exception e) {
         throw new RuntimeException(e);
      }
   }
}