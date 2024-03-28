package com.user.management.data.employee.dao.impl;

import com.user.management.appl.model.employee.Employee;
import com.user.management.appl.model.student.Student;
import com.user.management.data.connection.ConnectionHelper;
import com.user.management.data.employee.dao.EmployeeDao;
import com.user.management.data.student.dao.StudentDao;
import org.junit.jupiter.api.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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

    /**
     * This is to test get all students.
     */
    @Test
    public void testSaveEmployees() {
        Employee employee = new Employee();
        employee.setEmployeeId("00000000");

        when(employeeDao.saveEmployee(any(Employee.class))).thenReturn(employee);

        Employee savedEmployee = employeeDao.saveEmployee(employee);

        assertEquals(savedEmployee.getEmployeeId(), "00000000");
    }

    /**
     * This is to test get student by id.
     */
    @Test
    public void testFindEmployeeById() {
        Employee employee1 = new Employee();
        employee1.setEmployeeId("00000000");

        when(employeeDao.findEmployeeById("00000000")).thenReturn(employee1);

        Employee expectedEmployee = employeeDao.findEmployeeById("00000000");

        assertEquals(expectedEmployee, employee1);
        assertEquals(expectedEmployee.getEmployeeId(), employee1.getEmployeeId());
    }

    @Test
    public void testFindEmailByEmail() {
        Employee employee1 = new Employee();
        employee1.setEmployeeId("00000000");

        when(employeeDao.findEmployeeByEmail("amulongkateann@gmail.com")).thenReturn(employee1);

        Employee expectedEmployee = employeeDao.findEmployeeByEmail("amulongkateann@gmail.com");

        assertEquals(expectedEmployee, employee1);
        assertEquals(expectedEmployee.getEmployeeId(), employee1.getEmployeeId());
    }
}

