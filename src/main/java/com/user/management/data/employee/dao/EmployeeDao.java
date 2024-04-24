package com.user.management.data.employee.dao;

import com.user.management.appl.model.employee.Employee;

import java.sql.SQLException;
/**
 * The EmployeeDao interface manages employee data.
 */
public interface EmployeeDao {

    /**
     * Saves the given employee to the database.
     *
     * @param employee the employee object to be saved
     * @return the saved employee object
     */
    Employee saveEmployee(Employee employee);

    /**
     * Retrieves an employee by ID.
     *
     * @param employeeId the ID of the employee to retrieve
     * @return the Employee object to the given ID, or null if not found
     */
    Employee findEmployeeById(String employeeId);

    /**
     * Retrieves an employee by email.
     *
     * @param email the email of the employee to retrieve
     * @return the Employee object to the given email, or null if not found
     */
    Employee findEmployeeByEmail(String email);
}
