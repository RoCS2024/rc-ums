/**
 * This is a unit test for DAO Implementation.
 * */

package com.user.management.data.user.dao.impl;

import com.user.management.app.model.user.User;
import com.user.management.data.connection.ConnectionHelper;
import com.user.management.data.user.dao.UserDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class UserDaoImplTest {
    private UserDao userDao;

    @Mock
    private Connection connection;

    @Mock
    private PreparedStatement preparedStatement;

    @Mock
    private ResultSet resultSet;

    @BeforeEach
    void setUp() throws SQLException {
        MockitoAnnotations.initMocks(this);
        userDao = new UserDaoImpl();
        when(ConnectionHelper.getConnection()).thenReturn(connection);
        when(connection.prepareStatement(any(String.class))).thenReturn(preparedStatement);
        when(preparedStatement.executeQuery()).thenReturn(resultSet);
    }

    @Test
    void testGetUserById() throws SQLException {
        int userId = 1;
        when(resultSet.next()).thenReturn(true);
        when(resultSet.getInt("id")).thenReturn(userId);
        when(resultSet.getString("username")).thenReturn("testuser");
        when(resultSet.getString("password")).thenReturn("testpassword");
        when(resultSet.getString("entity_id")).thenReturn("entity123");
        when(resultSet.getTimestamp("date_modified")).thenReturn(new Timestamp(System.currentTimeMillis()));

        User user = userDao.getUserById(userId);
        assertNotNull(user);
        assertEquals(userId, user.getId());
    }

    @Test
    void testUpdateUser() throws SQLException {
        User user = new User(1, "testuser", "testpassword", "entity123", null, new Timestamp(System.currentTimeMillis()));
        when(preparedStatement.executeUpdate()).thenReturn(1);
        boolean result = userDao.updateUser(user);
        assertTrue(result);
    }
}