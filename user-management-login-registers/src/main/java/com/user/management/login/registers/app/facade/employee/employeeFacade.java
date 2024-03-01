package com.user.management.login.registers.app.facade.employee;

import com.user.management.login.registers.app.model.employee.Employee;
import com.user.management.login.registers.app.model.student.Student;

import java.sql.SQLException;

public interface employeeFacade {
    Employee saveEmployee(Employee employee) throws SQLException;
    Employee checkEmployeeId(String employeeId) throws SQLException;
}