package com.integrated.user.management.app.facade.user.impl;

import static org.junit.jupiter.api.Assertions.*;

class UserFacadeImplTest {

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