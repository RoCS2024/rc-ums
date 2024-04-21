package com.user.management.appl.facade.employee.Impl;

import com.user.management.appl.facade.employee.EmployeeFacade;
import com.user.management.appl.model.employee.Employee;
import com.user.management.data.employee.dao.EmployeeDao;
import com.user.management.data.employee.dao.impl.EmployeeDaoImpl;


public class EmployeeFacadeImpl implements EmployeeFacade {

    private  EmployeeDao employeeDao;

    public EmployeeFacadeImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeDao.saveEmployee(employee);
    }

    @Override
    public Employee findEmployeeById(String employeeId) {
        return employeeDao.findEmployeeById(employeeId);
    }

    @Override
    public Employee findEmployeeByEmail(String email) {
        return employeeDao.findEmployeeByEmail(email);
    }

}
