package com.user.management.data.employee.dao.impl;

import com.user.management.appl.model.employee.Employee;
import com.user.management.appl.model.student.Student;
import com.user.management.data.connection.ConnectionHelper;
import com.user.management.data.employee.dao.EmployeeDao;
import org.junit.jupiter.api.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * This is the Employee Dao Impl Test.
 * */
class EmployeeDaoImplTest {
    private EmployeeDao employeeDao;
    private List<Employee> employees;

    @BeforeEach
    public void setUp() {
        employees = new ArrayList<>();
        Employee employee1 = new Employee();
        Employee employee2 = new Employee();
        employees.add(employee1);
        employees.add(employee2);

        employeeDao = mock(EmployeeDao.class);
    }

    @Test
    public void testSaveEmployee(){
        Employee employee1 = new Employee();
        employee1.setEmployeeId("EMP21-001");

        when(employeeDao.saveEmployee(employee1)).thenReturn(employee1);

        Employee expectedEmployee = employeeDao.saveEmployee(employee1);

        verify(employeeDao).saveEmployee(employee1);

        assertEquals(expectedEmployee, employee1);
        assertEquals(expectedEmployee.getEmployeeId(), employee1.getEmployeeId());
    }
    @Test
    public void testFindEmployeeById(){
        Employee employee1 = new Employee();
        employee1.setEmployeeId("CT21-0073");

        when(employeeDao.findEmployeeById("CT21-0073")).thenReturn(employee1);

        Employee expectedEmployee = employeeDao.findEmployeeById("CT21-0073");

        assertEquals(expectedEmployee, employee1);
        assertEquals(expectedEmployee.getEmployeeId(), employee1.getEmployeeId());
    }
    @Test
    public void testFindEmployeeByEmail(){
        Employee employee1 = new Employee();
        employee1.setEmail("amulongkateann@gmail.com");

        when(employeeDao.findEmployeeByEmail("amulongkateann@gmail.com")).thenReturn(employee1);

        Employee expectedEmployee = employeeDao.findEmployeeByEmail("amulongkateann@gmail.com");

        assertEquals(expectedEmployee, employee1);
        assertEquals(expectedEmployee.getEmail(), employee1.getEmail());
    }

}
