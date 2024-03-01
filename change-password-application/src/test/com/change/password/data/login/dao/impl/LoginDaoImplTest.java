package com.change.password.data.login.dao.impl;

import com.change.password.app.model.login.Login;
import com.change.password.data.connection.ConnectionHelper;
import com.change.password.data.login.dao.LoginDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class LoginDaoImplTest {

    private LoginDao loginDao;
    private List<Login> logins;
    private Login login;

    @BeforeEach
    void setUp() {
        Login login1 = new Login();
        Login login2 = new Login();

        logins = new ArrayList<>();
        logins.add(login1);
        logins.add(login2);

        loginDao = mock(LoginDao.class);
    }

    @Test
    public void testUpdatePassword() throws SQLException {
        Login customer = new Login();
        try {
            when(loginDao.updatePassword(login)).thenAnswer(new Answer<Boolean>() {
                @Override
                public Boolean answer(InvocationOnMock invocationOnMock) throws Throwable {
                    Object[] arguments = invocationOnMock.getArguments();
                    if (arguments != null && arguments.length > 0 && arguments[0] != null){
                        Optional<Login> searchLogin = logins.stream().filter(c -> c.getId() == 1).findFirst();
                        if(searchLogin != null) {
                            logins.remove(searchLogin.get());
                            logins.add(login);
                            return true;
                        }
                    }
                    return false;
                }
            });
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Login updateResult = loginDao.updatePassword(customer);
        when(loginDao.getUsername()).thenReturn((List<Login>) logins);
        List<Login> loginList = loginDao.getUsername();
        Optional<Login> searchLogin = logins.stream().filter(c -> c.getId() == 1).findAny();
        Login expectedCustomer = searchLogin.get();

        assertEquals(updateResult, true);
        assertEquals(loginList.size(), 2);
        assertNotEquals(expectedCustomer, null);
        assertEquals(expectedCustomer.getUsername(), "Joshua");
    }

    @Test
    public void deletePassword() {
        when(loginDao.updatePassword("1")).then(new Answer<Boolean>() {
            @Override
            public Boolean answer(InvocationOnMock invocationOnMock) throws Throwable {
                Object[] arguments = invocationOnMock.getArguments();
                if (arguments != null && arguments.length > 0 && arguments[0] != null){
                    Optional<Login> searchLogin = logins.stream().filter(c -> c.getId() == 1).findFirst();
                    if(searchLogin != null) {
                        logins.remove(searchLogin.get());
                        return true;
                    }
                }
                return false;
            }
        });

        Login deleteResult = loginDao.updatePassword("1");
        when(loginDao.getUsername()).thenReturn(logins);
        List<Login> loginList = loginDao.getUsername();
        Optional<Login> searchUsername = logins.stream().filter(c -> c.getId() == 1).findAny();

        assertEquals(deleteResult, true);
        assertEquals(loginList.size(), 1);
        assertEquals(searchUsername, Optional.empty());
    }
}