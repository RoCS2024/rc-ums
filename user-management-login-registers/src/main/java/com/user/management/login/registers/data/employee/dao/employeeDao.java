package com.user.management.login.registers.data.employee.dao;

import com.user.management.login.registers.app.model.employee.Employee;
import com.user.management.login.registers.app.model.student.Student;

import java.sql.SQLException;

public interface employeeDao {
    Employee saveEmployee(Employee employee) throws SQLException;
    Employee checkEmployeeId(String employeeId) throws SQLException;
}
