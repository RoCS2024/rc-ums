package com.user.management.data.employee.dao;

import com.user.management.app.model.employee.Employee;

import java.sql.SQLException;

public interface employeeDao {
    Employee saveEmployee(Employee employee) throws SQLException;
    Employee checkEmployeeId(String employeeId) throws SQLException;
}
