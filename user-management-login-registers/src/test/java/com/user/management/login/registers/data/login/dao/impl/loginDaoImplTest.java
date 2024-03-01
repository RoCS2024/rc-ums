import com.user.management.login.registers.app.model.login.Login;
import com.user.management.login.registers.data.connection.ConnectionHelper;
import com.user.management.login.registers.data.login.dao.loginDao;
import com.user.management.login.registers.data.login.dao.impl.loginDaoImpl;
import org.junit.jupiter.api.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class loginDaoImplTest {

    private static loginDao loginDao;

    @BeforeAll
    static void setUp() {
        loginDao = new loginDaoImpl();
    }

    @Test
    void checkUsername_ValidCredentials_ReturnsLogin() {
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
            Login retrievedLogin = loginDao.checkUsername(username, password);

            assertNotNull(retrievedLogin);
            assertEquals(id, retrievedLogin.getId());
            assertEquals(username, retrievedLogin.getUsername());
            assertEquals(password, retrievedLogin.getPassword());
        } catch (SQLException e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }


    @Test
    void saveUser_ValidLogin_ReturnsLoginWithId() {
        Login testLogin = new Login();
        testLogin.setUsername("testUser");
        testLogin.setPassword("testPassword");
        testLogin.setEntityId("entityId");
        testLogin.setDateCreated(Timestamp.valueOf(LocalDateTime.now()));
        testLogin.setDateModified(Timestamp.valueOf(LocalDateTime.now()));

        try {
            Login savedLogin = loginDao.saveUser(testLogin);

            assertNotNull(savedLogin.getId());
            assertEquals(testLogin.getUsername(), savedLogin.getUsername());
            assertEquals(testLogin.getPassword(), savedLogin.getPassword());
            assertEquals(testLogin.getEntityId(), savedLogin.getEntityId());
            assertEquals(testLogin.getDateCreated(), savedLogin.getDateCreated());
            assertEquals(testLogin.getDateModified(), savedLogin.getDateModified());
        } catch (SQLException e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    void getMaxUserId_ReturnsMaxId() {
        try {
            long maxId = loginDao.getMaxUserId();
            assertEquals(1, maxId);
        } catch (SQLException e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }
}
