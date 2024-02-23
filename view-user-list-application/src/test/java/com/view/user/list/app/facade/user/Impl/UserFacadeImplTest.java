/**
 * The UserFacadeImplTest class provides unit tests for the UserFacadeImpl class.
 */
package com.view.user.list.app.facade.user.Impl;

import com.view.user.list.app.model.user.User;
import com.view.user.list.data.user.dao.UserDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class UserFacadeImplTest {

    @Mock
    private UserDao mockUserDao;

    @InjectMocks
    private UserFacadeImpl userFacade;


    /**
     * Initializes mock objects and the UserFacadeImpl instance before each test.
     */
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * Tests the getAllUsers method of UserFacadeImpl.
     *
     */
    @Test
    public void testGetAllUsers() throws SQLException {

        List<User> expectedUsers = new ArrayList<>();
        User user1 = new User();
        user1.setUserId(1);
        user1.setUserName("testUser1");
        expectedUsers.add(user1);

        // Mocking UserDao behavior
        when(mockUserDao.getAllUsers()).thenReturn(expectedUsers);

        // Calling the method under test
        List<User> actualUsers = userFacade.getAllUsers();

        // Asserting the result
        assertEquals(expectedUsers.size(), actualUsers.size());
    }
}