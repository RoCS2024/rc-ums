package com.user.management.data.employee.dao;

import com.user.management.app.model.employee.Employee;

import java.sql.SQLException;

public interface EmployeeDao {
    Employee saveEmployee(Employee employee) throws SQLException;
    Employee findEmployeeById(String employeeId) throws SQLException;
}
