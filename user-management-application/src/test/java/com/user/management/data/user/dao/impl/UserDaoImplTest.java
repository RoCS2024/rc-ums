package com.user.management.data.user.dao.impl;

import com.user.management.app.model.user.User;
import com.user.management.data.connection.ConnectionHelper;
import com.user.management.data.user.dao.UserDao;
import com.user.management.data.user.dao.impl.UserDaoImpl;
import org.junit.jupiter.api.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class UserDaoImplTest {

    private static UserDao UserDao;

    @BeforeAll
    static void setUp() {
        UserDao = new UserDaoImpl();
    }

    @Mock
    private Connection mockConnection;

    @Mock
    private PreparedStatement mockPreparedStatement;

    @Mock
    private ResultSet mockResultSet;

    @InjectMocks
    private UserDaoImpl userDao;

    @Mock
    private ResultSet resultSet;
    @Mock
    private PreparedStatement preparedStatement;

    @Test
    public void testGetAllUsers() throws SQLException {
        List<User> expectedUserList = new ArrayList<>();
        User user1 = new User();
        user1.setId(1);
        user1.setUsername("testUser1");
        user1.setPassword("password1");
        user1.setEntity_id("entity1");
        user1.setDate_created(new Timestamp(System.currentTimeMillis()));
        user1.setDate_modified(new Timestamp(System.currentTimeMillis()));
        expectedUserList.add(user1);

        // Mocking database interaction
        when(mockConnection.prepareStatement(any())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true).thenReturn(false);
        when(mockResultSet.getInt("ID")).thenReturn(user1.getId());
        when(mockResultSet.getString("USERNAME")).thenReturn(user1.getUsername());
        when(mockResultSet.getString("PASSWORD")).thenReturn(user1.getPassword());
        when(mockResultSet.getString("ENTITY_ID")).thenReturn(user1.getEntity_id());
        when(mockResultSet.getTimestamp("DATE_CREATED")).thenReturn(user1.getDate_created());
        when(mockResultSet.getTimestamp("DATE_MODIFIED")).thenReturn(user1.getDate_modified());

        // Calling the method under test
        List<User> resultUserList = UserDao.getAllUsers();

        // Asserting the result
        assertEquals(expectedUserList.size(), resultUserList.size());
    }

    @Test
    void checkUsername_ValidCredentials_ReturnsUser() {
        String username = "testUser_" + System.currentTimeMillis(); // Generate unique username
        String password = "testPassword";
        long id = 2;
        String entityId = "entityId";
        Timestamp dateCreated = Timestamp.valueOf(LocalDateTime.now());
        Timestamp dateModified = Timestamp.valueOf(LocalDateTime.now());

        try (Connection connection = ConnectionHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO login (id, username, password) VALUES (?, ?, ?)")) {
            preparedStatement.setLong(1, id);
            preparedStatement.setString(2, username);
            preparedStatement.setString(3, password);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            fail("Error inserting test data: " + e.getMessage());
        }

        try {
            User retrievedUser = UserDao.checkUsername(username, password);

            assertNotNull(retrievedUser);
            assertEquals(id, retrievedUser.getId());
            assertEquals(username, retrievedUser.getUsername());
            assertEquals(password, retrievedUser.getPassword());
        } catch (SQLException e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }


    @Test
    void saveUser_ValidUser_ReturnsUserWithId() {
        User testLogin = new User();
        testLogin.setUsername("testUser");
        testLogin.setPassword("testPassword");
        testLogin.setEntity_id("entityId");
        testLogin.setDate_created(Timestamp.valueOf(LocalDateTime.now()));
        testLogin.setDate_modified(Timestamp.valueOf(LocalDateTime.now()));

        try {
            User savedLogin = UserDao.saveUser(testLogin);

            assertNotNull(savedLogin.getId());
            assertEquals(testLogin.getUsername(), savedLogin.getUsername());
            assertEquals(testLogin.getPassword(), savedLogin.getPassword());
            assertEquals(testLogin.getEntity_id(), savedLogin.getEntity_id());
            assertEquals(testLogin.getDate_created(), savedLogin.getDate_created());
            assertEquals(testLogin.getDate_modified(), savedLogin.getDate_modified());
        } catch (SQLException e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    void getMaxUserId_ReturnsMaxId() {
        try {
            long maxId = UserDao.getMaxUserId();
            assertEquals(1, maxId);
        } catch (SQLException e) {
            fail("Exception thrown: " + e.getMessage());
        }
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
