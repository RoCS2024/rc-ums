package java.com.user.management.data.user.dao.impl;

import com.user.management.app.model.user.User;
import com.user.management.data.connection.ConnectionHelper;
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

//    private static UserDao UserDao;

//    @BeforeAll
//    static void setUp() {
//        UserDao = new UserDaoImpl();
//    }

//    @Mock
//    private Connection mockConnection;

//    @Mock
//    private PreparedStatement mockPreparedStatement;

//    @Mock
//    private ResultSet mockResultSet;

//    @InjectMocks
//    private UserDaoImpl userDao;

//    @Mock
//    private ResultSet resultSet;
//    @Mock
//    private PreparedStatement preparedStatement;

//    @Test
//    public void testGetAllUsers() {
//        List<User> expectedUserList = new ArrayList<>();
//        User user1 = new User();
//        user1.setId(1);
//        user1.setUsername("testUser1");
//        user1.setPassword("password1");
//        user1.setEntity_id("entity1");
//        user1.setDate_created(new Timestamp(System.currentTimeMillis()));
//        user1.setDate_modified(new Timestamp(System.currentTimeMillis()));
//        expectedUserList.add(user1);

//        // Mocking database interaction
//        try {
//            when(mockConnection.prepareStatement(any())).thenReturn(mockPreparedStatement);
//            when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
//            when(mockResultSet.next()).thenReturn(true).thenReturn(false);
//            when(mockResultSet.getInt("ID")).thenReturn(user1.getId());
//            when(mockResultSet.getString("USERNAME")).thenReturn(user1.getUsername());
//            when(mockResultSet.getString("PASSWORD")).thenReturn(user1.getPassword());
//            when(mockResultSet.getString("ENTITY_ID")).thenReturn(user1.getEntity_id());
//            when(mockResultSet.getTimestamp("DATE_CREATED")).thenReturn(user1.getDate_created());
//            when(mockResultSet.getTimestamp("DATE_MODIFIED")).thenReturn(user1.getDate_modified());
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }


        // Calling the method under test
//        List<User> resultUserList = UserDao.getAllUsers();

//        // Asserting the result
//        assertEquals(expectedUserList.size(), resultUserList.size());
//    }

//    @Test
//    void checkUsername_ValidCredentials_ReturnsUser() {
//        String username = "testUser_" + System.currentTimeMillis(); // Generate unique username
//        String password = "testPassword";
//        long id = 2;
//        String entityId = "entityId";
//       Timestamp dateCreated = Timestamp.valueOf(LocalDateTime.now());
//        Timestamp dateModified = Timestamp.valueOf(LocalDateTime.now());

//        try (Connection connection = ConnectionHelper.getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(
//                     "INSERT INTO login (id, username, password) VALUES (?, ?, ?)")) {
//            preparedStatement.setLong(1, id);
//            preparedStatement.setString(2, username);
//            preparedStatement.setString(3, password);
//            preparedStatement.executeUpdate();
//        } catch (Exception e) {
//            fail("Error inserting test data: " + e.getMessage());
//        }

//        try {
//            User retrievedUser = UserDao.getUsername(username);

//            assertNotNull(retrievedUser);
//            assertEquals(id, retrievedUser.getId());
//            assertEquals(username, retrievedUser.getUsername());
//            assertEquals(password, retrievedUser.getPassword());
//        } catch (Exception e) {
//            fail("Exception thrown: " + e.getMessage());
//        }
//    }


//    @Test
//    void saveUser_ValidUser_ReturnsUserWithId() {
//        User testLogin = new User();
//        testLogin.setUsername("testUser");
//        testLogin.setPassword("testPassword");
//        testLogin.setEntity_id("entityId");
//        testLogin.setDate_created(Timestamp.valueOf(LocalDateTime.now()));
//        testLogin.setDate_modified(Timestamp.valueOf(LocalDateTime.now()));

//        try {
//            User savedLogin = UserDao.saveUser(testLogin);

//            assertNotNull(savedLogin.getId());
//            assertEquals(testLogin.getUsername(), savedLogin.getUsername());
 //           assertEquals(testLogin.getPassword(), savedLogin.getPassword());
//            assertEquals(testLogin.getEntity_id(), savedLogin.getEntity_id());
//            assertEquals(testLogin.getDate_created(), savedLogin.getDate_created());
//            assertEquals(testLogin.getDate_modified(), savedLogin.getDate_modified());
//        } catch (Exception e) {
 //           fail("Exception thrown: " + e.getMessage());
 //       }
 //   }

//    @Test
//    void getMaxUserId_ReturnsMaxId() {
//        try {
//            long maxId = UserDao.getMaxUserId();
//            assertEquals(1, maxId);
//        } catch (Exception e) {
//            fail("Exception thrown: " + e.getMessage());
//        }
//    }

//    @Test
//    void testGetUserById() {
//       int userId = 1;
//        try {
//            when(resultSet.next()).thenReturn(true);
//            when(resultSet.getInt("id")).thenReturn(userId);
//            when(resultSet.getString("username")).thenReturn("testuser");
//            when(resultSet.getString("password")).thenReturn("testpassword");
//            when(resultSet.getString("entity_id")).thenReturn("entity123");
//            when(resultSet.getTimestamp("date_modified")).thenReturn(new Timestamp(System.currentTimeMillis()));

//            User user = userDao.getUserById(userId);
//            assertNotNull(user);
//            assertEquals(userId, user.getId());
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }

//    }
//    @Test
//    void testUpdateUser()  {
//        User user = new User(1, "testuser", "testpassword", "entity123", null, new Timestamp(System.currentTimeMillis()));
//        try {
//            when(preparedStatement.executeUpdate()).thenReturn(1);
//            boolean result = userDao.updateUser();
//            assertTrue(result);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//    @Test
//    public void testUpdatePassword(String username) {
//        User user = new User();
//        user.setId(1);
//        user.setUsername("Joshua");

//        UserDao userDao = Mockito.mock(UserDao.class);

//        Mockito.when(userDao.updatePassword(user)).thenAnswer(new Answer<Boolean>() {
//           @Override
 //           public Boolean answer(InvocationOnMock invocation) throws Throwable {
//                Object[] arguments = invocation.getArguments();
//                if (arguments != null && arguments.length > 0 && arguments[0] != null) {
//                    User userToUpdate = (User) arguments[0];
//                    if (userToUpdate.getId() == 1) {
//                        // Assuming updatePassword just returns true if the user ID is 1
//                        return true;
//                    }
//                }
//                return false;
//            }
//        });

//        User updateResult = userDao.updatePassword(user);
//        List<User> loginList = (List<User>) userDao.getUsername(username);
//        Optional<User> searchLogin = loginList.stream().filter(c -> c.getId() == 1).findAny();
//        User expectedCustomer = searchLogin.get();

//        assertEquals(true, updateResult);
//        assertEquals(1, loginList.size());
//        assertEquals("Joshua", expectedCustomer.getUsername());
//    }
//    @Test
//    public void testDeletePassword(String username) {
//        User user = new User();
//        user.setId(1);
//        user.setUsername("Joshua");

//        List<User> usersList = new ArrayList<>();
//        usersList.add(user);

//        UserDao userDao = Mockito.mock(UserDao.class);

//        Mockito.when(userDao.updatePassword(user)).thenAnswer(new Answer<Boolean>() {
//            @Override
//            public Boolean answer(InvocationOnMock invocation) throws Throwable {
//                Object[] arguments = invocation.getArguments();
//                if (arguments != null && arguments.length > 0 && arguments[0] != null) {
//                    String userId = (String) arguments[0];
 //                   Optional<User> searchLogin = usersList.stream().filter(c -> c.getId() == Integer.parseInt(userId)).findFirst();
//                    if (searchLogin.isPresent()) {
//                        usersList.remove(searchLogin.get());
//                        return true;
//                    }
//                }
//                return false;
//            }
//        });

//        User deleteResult = userDao.updatePassword(user);
//        List<User> loginList = (List<User>) userDao.getUsername(username);
//        Optional<User> searchUsername = loginList.stream().filter(c -> c.getId() == 1).findAny();

//        assertEquals(true, deleteResult);
//        assertEquals(0, loginList.size());
//        assertEquals(Optional.empty(), searchUsername);
//    }

//@Test
//public void testForgotPassword(String username) {
   //User user = new User();
   //user.setId(1);
   //user.setUsername("penggu");

   //UserDao userDao = Mockito.mock(UserDao.class);

   //Mockito.when(userDao.forgotPassword(user)).thenAnswer(new Answer<Boolean>() {
      //@Override
     // public Boolean answer(InvocationOnMock invocation) throws Throwable {
         //Object[] arguments = invocation.getArguments();
        // if (arguments != null && arguments.length > 0 && arguments[0] != null) {
            //User userToUpdate = (User) arguments[0];
            //if (userToUpdate.getId() == 1) {
               // Assuming updatePassword just returns true if the user ID is 1
              // return true;
           // }
        // }
        // return false;
     // }
  // });

   //User updateResult = userDao.updatePassword(user);
   //List<User> loginList = (List<User>) userDao.getUsername(username);
  // Optional<User> searchLogin = loginList.stream().filter(c -> c.getId() == 1).findAny();
  // User expectedCustomer = searchLogin.get();

   //assertEquals(true, updateResult);
  // assertEquals(1, loginList.size());
   //assertEquals("Joshua", expectedCustomer.getUsername());
}
   }