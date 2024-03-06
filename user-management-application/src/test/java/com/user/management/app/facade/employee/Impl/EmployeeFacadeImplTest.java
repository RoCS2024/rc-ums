package com.user.management.app.facade.employee.Impl;

import com.user.management.app.model.employee.Employee;
import com.user.management.data.employee.dao.EmployeeDao;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EmployeeFacadeImplTest {

    @Test
    void testSaveEmployee() throws SQLException {
        Employee employee = new Employee();
        employee.setEmployeeNo("EMP21-0143");
        employee.setLastName("Magnaye");
        employee.setFirstName("Justine");
        EmployeeDao employeeDao = mock(EmployeeDao.class);
        when(employeeDao.saveEmployee(employee)).thenReturn(employee);

        EmployeeFacadeImpl employeeFacade = new EmployeeFacadeImpl(employeeDao);
        Employee result = employeeFacade.saveEmployee(employee);

        assertNotNull(result, "Saved employee should not be null.");
        assertEquals(employee, result, "Saved employee should match input employee.");
        verify(employeeDao, times(1)).saveEmployee(employee);
    }

    @Test
    void testCheckEmployeeId() throws SQLException {
        String employeeId = "EMP21-0143";
        Employee expectedEmployee = new Employee();
        expectedEmployee.setEmployeeNo(employeeId);
        expectedEmployee.setLastName("Magnaye");
        expectedEmployee.setFirstName("Justine");
        EmployeeDao employeeDao = mock(EmployeeDao.class);
        when(employeeDao.findEmployeeById(employeeId)).thenReturn(expectedEmployee);

        EmployeeFacadeImpl employeeFacade = new EmployeeFacadeImpl(employeeDao);
        Employee result = employeeFacade.findEmployeeById(employeeId);

        assertNotNull(result, "Returned employee should not be null.");
        assertEquals(expectedEmployee, result, "Returned employee should match expected employee.");
        verify(employeeDao, times(1)).findEmployeeById(employeeId);
    }
}
