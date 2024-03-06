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

import static org.junit.jupiter.api.Assertions.*;

class UserDaoImplTest {

    private static UserDao UserDao;

    @BeforeAll
    static void setUp() {
        UserDao = new UserDaoImpl();
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
}
