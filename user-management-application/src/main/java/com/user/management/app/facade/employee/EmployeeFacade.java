package com.user.management.app.facade.employee;

import com.user.management.app.model.employee.Employee;

import java.sql.SQLException;

public interface EmployeeFacade {
    Employee saveEmployee(Employee employee) throws SQLException;
    Employee checkEmployeeId(String employeeId) throws SQLException;
}