package com.user.management.appl.facade.employee;

import com.user.management.appl.model.employee.Employee;

import java.sql.SQLException;
/**
 * This is the Employee Facade.
 * */
public interface EmployeeFacade {
    Employee saveEmployee(Employee employee);
    Employee findEmployeeById(String employeeId);
    Employee findEmployeeByEmail(String email);
}