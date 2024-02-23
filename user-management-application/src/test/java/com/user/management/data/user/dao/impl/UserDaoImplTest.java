/**
 * This is a unit test for DAO Implementation.
 * */

package com.user.management.data.user.dao.impl;

import com.user.management.app.model.user.User;
import com.user.management.data.connection.ConnectionHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class UserDaoImplTest {
    @Mock
    Connection connection;
    @Mock
    PreparedStatement preparedStatement;
    @Mock
    ResultSet resultSet;

    UserDaoImpl userDao;

    @BeforeEach
    void setUp() throws SQLException {
        MockitoAnnotations.openMocks(this);
        userDao = new UserDaoImpl();
        when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);
        when(preparedStatement.executeQuery()).thenReturn(resultSet);
    }

    @Test
    void getUserById_shouldReturnUser_whenIdExists() throws SQLException {
        mockConnectionHelper();
        User mockUser = new User(1, "john_doe", "password123", "entity123", null, null);
        when(resultSet.next()).thenReturn(true);
        when(resultSet.getInt("id")).thenReturn(mockUser.getId());
        when(resultSet.getString("username")).thenReturn(mockUser.getUsername());
        when(resultSet.getString("password")).thenReturn(mockUser.getPassword());
        when(resultSet.getString("entity_id")).thenReturn(mockUser.getEntity_id());
        when(resultSet.getTimestamp("date_modified")).thenReturn(mockUser.getDate_modified());

        User result = userDao.getUserById(1);
        verify(preparedStatement).setInt(1, 1);
        verify(preparedStatement).executeQuery();
        assertEquals(mockUser, result);
    }

    @Test
    void getUserById_shouldReturnNull_whenIdDoesNotExist() throws SQLException {
        when(resultSet.next()).thenReturn(false);
        User result = userDao.getUserById(999);
        verify(preparedStatement).setInt(1, 999);
        verify(preparedStatement).executeQuery();
        assertNull(result);
    }

    @Test
    void addUser_shouldReturnTrue_whenAdditionSuccessful() throws SQLException {
        mockConnectionHelper();
        User mockUser = new User(1, "john_doe", "password123", "entity123", null, null);
        when(resultSet.next()).thenReturn(false);
        when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);
        when(preparedStatement.executeUpdate()).thenReturn(1);

        boolean result = userDao.addUser(mockUser);
        verify(preparedStatement).setString(1, mockUser.getUsername());
        verify(preparedStatement).setString(2, mockUser.getPassword());
        verify(preparedStatement).setString(3, mockUser.getEntity_id());
        verify(preparedStatement).setTimestamp(4, any(Timestamp.class));
        verify(preparedStatement).setTimestamp(5, any(Timestamp.class));

        verify(preparedStatement).executeUpdate();
        assertTrue(result);
    }

    @Test
    void addUser_shouldReturnFalse_whenAdditionFails() throws SQLException {
        mockConnectionHelper();

        User mockUser = new User(1, "john_doe", "password123", "entity123", null, null);
        when(resultSet.next()).thenReturn(false);
        when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);
        when(preparedStatement.executeUpdate()).thenReturn(0);
        boolean result = userDao.addUser(mockUser);

        verify(preparedStatement).setString(1, mockUser.getUsername());
        verify(preparedStatement).setString(2, mockUser.getPassword());
        verify(preparedStatement).setString(3, mockUser.getEntity_id());
        verify(preparedStatement).setTimestamp(4, any(Timestamp.class));
        verify(preparedStatement).setTimestamp(5, any(Timestamp.class));

        verify(preparedStatement).executeUpdate();
        assertFalse(result);
    }

    @Test
    void addUser_shouldReturnFalse_whenUserAlreadyExists() throws SQLException {
        mockConnectionHelper();
        User mockUser = new User(1, "john_doe", "password123", "entity123", null, null);
        when(resultSet.next()).thenReturn(true);
        boolean result = userDao.addUser(mockUser);
        verify(preparedStatement, never()).setString(anyInt(), anyString());
        verify(preparedStatement, never()).setTimestamp(anyInt(), any(Timestamp.class));
        verify(preparedStatement, never()).executeUpdate();
        assertFalse(result);
    }

    @Test
    void updateUser_shouldReturnTrue_whenUpdateSuccessful() throws SQLException {
        mockConnectionHelper();
        User mockUser = new User(1, "john_doe", "password123", "entity123", null, null);
        when(resultSet.next()).thenReturn(true);
        when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);
        when(preparedStatement.executeUpdate()).thenReturn(1);
        boolean result = userDao.updateUser(mockUser);
        verify(preparedStatement).setString(1, mockUser.getUsername());
        verify(preparedStatement).setString(2, mockUser.getPassword());
        verify(preparedStatement).setString(3, mockUser.getEntity_id());
        verify(preparedStatement).setTimestamp(4, mockUser.getDate_modified());
        verify(preparedStatement).setInt(5, mockUser.getId());

        verify(preparedStatement).executeUpdate();
        assertTrue(result);
    }

    @Test
    void updateUser_shouldReturnFalse_whenUpdateFails() throws SQLException {
        mockConnectionHelper();
        User mockUser = new User(1, "john_doe", "password123", "entity123", null, null);
        when(resultSet.next()).thenReturn(true);
        when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);
        when(preparedStatement.executeUpdate()).thenReturn(0);
        boolean result = userDao.updateUser(mockUser);
        verify(preparedStatement).setString(1, mockUser.getUsername());
        verify(preparedStatement).setString(2, mockUser.getPassword());
        verify(preparedStatement).setString(3, mockUser.getEntity_id());
        verify(preparedStatement).setTimestamp(4, mockUser.getDate_modified());
        verify(preparedStatement).setInt(5, mockUser.getId());
        verify(preparedStatement).executeUpdate();
        assertFalse(result);
    }

    public void mockConnectionHelper() throws SQLException {
        ConnectionHelper connectionHelper = org.mockito.Mockito.mock(ConnectionHelper.class);
        when(ConnectionHelper.getConnection()).thenReturn(connection);
    }
}
