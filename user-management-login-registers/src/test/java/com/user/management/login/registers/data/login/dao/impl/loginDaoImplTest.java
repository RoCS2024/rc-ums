package com.user.management.login.registers.data.login.dao.impl;

import com.user.management.login.registers.app.model.login.Login;
import com.user.management.login.registers.data.login.dao.impl.loginDaoImpl;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class loginDaoImplTest {

    private static loginDaoImpl loginDao;

    @BeforeAll
    static void setUp() {
        loginDao = new loginDaoImpl();
    }

    @AfterAll
    static void tearDown() {
    }

    @Test
    void checkUsername() {
        String username = "testUser";
        String password = "testPassword";

        try {
            Login actualLogin = loginDao.checkUsername(username, password);

            assertNull(actualLogin);
        } catch (SQLException e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    void saveUser() {
        Login testLogin = new Login();
        testLogin.setUsername("testUser");
        testLogin.setPassword("testPassword");

        try {
            loginDao.saveUser(testLogin);
        } catch (SQLException e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    void getMaxUserId() {
        try {
            long maxId = loginDao.getMaxUserId();

            assertEquals(0, maxId);
        } catch (SQLException e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }
}
