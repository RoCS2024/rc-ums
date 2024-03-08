package com.user.management.app.facade.employee;

import com.user.management.app.model.employee.Employee;

import java.sql.SQLException;
/**
 * This is the Employee Facade.
 * */
public interface EmployeeFacade {
    Employee saveEmployee(Employee employee);
    Employee findEmployeeById(String employeeId);
}