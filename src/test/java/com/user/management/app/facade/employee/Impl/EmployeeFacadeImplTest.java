package com.user.management.app.facade.employee.Impl;

import com.user.management.app.model.employee.Employee;
import com.user.management.data.employee.dao.EmployeeDao;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
/**
 * This is the Employee Facade Impl Test.
 * */
class EmployeeFacadeImplTest {

    private Employee employeeDao;

    @Test
    void testSaveEmployee() {
        Employee employee = new Employee();
        employee.setEmployeeId("EMP21-0143");
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
    void testCheckEmployeeId() {
        String employeeId = "EMP21-0143";
        Employee expectedEmployee = new Employee();
        expectedEmployee.setEmployeeId(employeeId);
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
