package com.user.management.appl.facade.employee.Impl;

import com.user.management.appl.facade.employee.EmployeeFacade;
import com.user.management.appl.model.employee.Employee;
import com.user.management.data.employee.dao.EmployeeDao;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
/**
 * This is the Employee Facade Impl Test.
 * */
class EmployeeFacadeImplTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeFacadeImplTest.class);

    @InjectMocks
    private EmployeeFacade employeeFacade = new EmployeeFacadeImpl();

    @Mock
    private EmployeeDao employeeDao;

    @Mock
    private Employee employee;

    @Mock
    private Employee getEmployee;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        employee.setEmployeeId("EMP21-0143");
        getEmployee.getEmployeeId ();
        when(employeeDao.findEmployeeById("EMP21-0143")).thenReturn(employee);
    }

    @AfterEach
    public void validate() {
        validateMockitoUsage();
    }

    @Test
    void testSaveEmployee() {
        try {
            Employee employee = new Employee();
            employee.setEmployeeId("EMP21-0143");
            employee.setLastName("Guapo");
            employee.setFirstName("Mister");
            EmployeeDao employeeDao = mock(EmployeeDao.class);
            when(employeeDao.saveEmployee(employee)).thenReturn(employee);

            EmployeeFacadeImpl employeeFacade = new EmployeeFacadeImpl(employeeDao);
            Employee result = employeeFacade.saveEmployee(employee);

            assertNotNull(result, "Saved employee should not be null.");
            assertEquals(employee, result, "Saved employee should match input employee.");
            verify(employeeDao, times(1)).saveEmployee(employee);

        } catch (Exception e) {
            LOGGER.error("Exception caught: " + e.getMessage());
        }
    }


    @Test
    void testCheckEmployeeId() {
        String employeeId = "EMP21-0143";
        Employee expectedEmployee = new Employee();
        expectedEmployee.setEmployeeId(employeeId);
        expectedEmployee.setLastName("Guapo");
        expectedEmployee.setFirstName("Mister");
        EmployeeDao employeeDao = mock(EmployeeDao.class);
        when(employeeDao.findEmployeeById("EMP21-0143")).thenReturn(expectedEmployee);

        EmployeeFacadeImpl employeeFacade = new EmployeeFacadeImpl(employeeDao);
        Employee result = employeeFacade.findEmployeeById(employeeId);

        assertNotNull(result, "Returned employee should not be null.");
        assertEquals(expectedEmployee, result, "Returned employee should match expected employee.");
        verify(employeeDao, times(1)).findEmployeeById("EMP21-0143");
    }

    @Test
    void testCheckEmployeeEmail() {

        String employeeEmail = "misterguapo@gmail.com";
        Employee expectedEmployee = new Employee();
        expectedEmployee.setEmail(employeeEmail);
        expectedEmployee.setLastName("Guapo");
        expectedEmployee.setFirstName("Mister");
        EmployeeDao employeeDao = mock(EmployeeDao.class);
        when(employeeDao.findEmployeeByEmail(employeeEmail)).thenReturn(expectedEmployee);

        EmployeeFacadeImpl employeeFacade = new EmployeeFacadeImpl(employeeDao);
        Employee result = employeeFacade.findEmployeeByEmail(employeeEmail);

        assertNotNull(result, "Returned employee should not be null.");
        assertEquals(expectedEmployee, result, "Returned employee should match expected employee.");
        verify(employeeDao, times(1)).findEmployeeByEmail(employeeEmail);


    }
}
