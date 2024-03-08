package com.user.management.app.facade.employee.Impl;

import com.user.management.app.facade.employee.EmployeeFacade;
import com.user.management.app.model.employee.Employee;
import com.user.management.data.employee.dao.EmployeeDao;
import com.user.management.data.employee.dao.impl.EmployeeDaoImpl;

import java.sql.SQLException;
/**
 * This is the Employee Facade Impl.
 * */
public class EmployeeFacadeImpl implements EmployeeFacade {
    private final EmployeeDao employeeDao;

    public EmployeeFacadeImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public EmployeeFacadeImpl() {
        this.employeeDao = new EmployeeDaoImpl();
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeDao.saveEmployee(employee);
    }

    @Override
    public Employee findEmployeeById(String employeeId) {
        return employeeDao.findEmployeeById(employeeId);
    }
}
