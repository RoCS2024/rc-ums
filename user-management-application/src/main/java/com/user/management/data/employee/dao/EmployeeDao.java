package com.user.management.data.employee.dao;

import com.user.management.app.model.employee.Employee;

import java.sql.SQLException;
/**
 * This is the Employee Dao.
 * */
public interface EmployeeDao {
    Employee saveEmployee(Employee employee);
    Employee findEmployeeById(String employeeId);
    Employee findEmployeeByEmail(String email);
}
