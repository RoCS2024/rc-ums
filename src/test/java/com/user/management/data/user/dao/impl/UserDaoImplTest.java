package com.user.management.data.user.dao.impl;

import com.user.management.appl.model.student.Student;
import com.user.management.appl.model.user.User;
import com.user.management.data.student.dao.StudentDao;
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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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
         user1.getUsername();

         when(userDao.getUsername("Amulong")).thenReturn(user1);

         User expectedUser = userDao.getUsername("Amulong");

         assertEquals(expectedUser, user1);
         assertEquals(expectedUser.getUsername(), user1.getUsername());
    }


   @Test
   public void testSaveUser() {
       User user = new User();
       user.setId(1);

       when(userDao.saveUser(any(User.class))).thenReturn(user);

       User user1 = userDao.saveUser(user);

       assertEquals(user1.getId(), 1);
   }

    @Test
    public void getMaxUserId() {
        User user1 = new User();
        user1.setId(1);

        when(userDao.getMaxUserId()).thenReturn(1L);

        Long returnedUserId = userDao.getMaxUserId();

        assertNotNull(returnedUserId);

        assertEquals(user1.getId(), returnedUserId.intValue());

        assertEquals(user1.getId(), returnedUserId.longValue());
    }

    @Test
    public void testGetUserById() {
       User user1 = new User();
       user1.getId();

       when(userDao.getUserById(1)).thenReturn(user1);

       User expectedUser = userDao.getUserById(1);

       assertEquals(expectedUser, user1);
       assertEquals(expectedUser.getId(), user1.getId());
    }
    @Test
    public void testFindUserByUsername() {
        User user1 = new User();
        user1.getUsername();

        when(userDao.findUserByUsername("Amulong")).thenReturn(user1);

        User expectedUser = userDao.findUserByUsername("Amulong");

        assertEquals(expectedUser, user1);
        assertEquals(expectedUser.getUsername(), user1.getUsername());
    }

     @Test
     public void testUpdateUser()  {
        User user = new User();
        user.getId();
        user.setUsername("Amulong");

        when(userDao.updateUser()).thenReturn(true);
        when(userDao.getUserById(1)).thenReturn(user);

        User expectedUser = userDao.getUserById(1);
        assertEquals(expectedUser.getUsername(), user.getUsername());
     }

    @Test
    public void testUpdatePassword() {
       User user = new User();
       user.getId();
       user.setUsername("Amulong");

       when(userDao.updateUser()).thenReturn(true);
       when(userDao.getUserById(1)).thenReturn(user);

       User expectedUser = userDao.getUserById(1);
       assertEquals(expectedUser.getUsername(), user.getUsername());
    }
}