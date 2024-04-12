package com.user.management.appl.facade.employee;

import com.user.management.appl.model.employee.Employee;

import java.sql.SQLException;
/**
 * This is the interface to the Employee Facade
 */
public interface EmployeeFacade {

    /**
     * This saves a new Employee in the database.
     *
     * @param employee is the employee to be saved.
     * @return True if the employee was successfully saved.
     */
    Employee saveEmployee(Employee employee);

    /**
     * This finds an employee by their ID.
     *
     * @param employeeId is the employee ID to find in the database.
     * @return employee ID from the database
     */
    Employee findEmployeeById(String employeeId);

    /**
     * This finds a student by their email.
     *
     * @param email is the employee email to find in the database.
     * @return employee email from the database
     */
    Employee findEmployeeByEmail(String email);
}