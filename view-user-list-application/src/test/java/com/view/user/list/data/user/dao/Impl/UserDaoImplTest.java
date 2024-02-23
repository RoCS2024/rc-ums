/**
 * The UserDaoImplTest class provides unit tests for the UserDaoImpl class.
 */
package com.view.user.list.data.user.dao.Impl;

import com.view.user.list.app.model.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class UserDaoImplTest {

    @Mock
    private Connection mockConnection;

    @Mock
    private PreparedStatement mockPreparedStatement;

    @Mock
    private ResultSet mockResultSet;

    @InjectMocks
    private UserDaoImpl userDao;

    /**
     * Initializes mock objects and the UserDaoImpl instance before each test.
     */
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        userDao = new UserDaoImpl();
    }

    /**
     * Tests the getAllUsers method of UserDaoImpl.
     *
     * @throws SQLException if a database access error occurs or this method is called on a closed connection.
     */
    @Test
    public void testGetAllUsers() throws SQLException {
        List<User> expectedUserList = new ArrayList<>();
        User user1 = new User();
        user1.setUserId(1);
        user1.setUserName("testUser1");
        user1.setPassword("password1");
        user1.setEntityId("entity1");
        user1.setDateCreated(new Timestamp(System.currentTimeMillis()));
        user1.setDateModified(new Timestamp(System.currentTimeMillis()));
        expectedUserList.add(user1);

        // Mocking database interaction
        when(mockConnection.prepareStatement(any())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true).thenReturn(false);
        when(mockResultSet.getInt("ID")).thenReturn(user1.getUserId());
        when(mockResultSet.getString("USERNAME")).thenReturn(user1.getUserName());
        when(mockResultSet.getString("PASSWORD")).thenReturn(user1.getPassword());
        when(mockResultSet.getString("ENTITY_ID")).thenReturn(user1.getEntityId());
        when(mockResultSet.getTimestamp("DATE_CREATED")).thenReturn(user1.getDateCreated());
        when(mockResultSet.getTimestamp("DATE_MODIFIED")).thenReturn(user1.getDateModified());

        // Calling the method under test
        List<User> resultUserList = userDao.getAllUsers();

        // Asserting the result
        assertEquals(expectedUserList.size(), resultUserList.size());
    }
}
