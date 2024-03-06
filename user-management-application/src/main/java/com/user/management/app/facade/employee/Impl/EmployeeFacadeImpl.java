package com.user.management.app.facade.employee.Impl;


import com.user.management.app.facade.employee.EmployeeFacade;
import com.user.management.app.model.employee.Employee;
import com.user.management.data.employee.dao.impl.employeeDaoImpl;

import java.sql.SQLException;

public class EmployeeFacadeImpl implements EmployeeFacade {
    private final com.user.management.data.employee.dao.employeeDao employeeDao;

    public EmployeeFacadeImpl(com.user.management.data.employee.dao.employeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public EmployeeFacadeImpl() {
        this.employeeDao = new employeeDaoImpl();
    }

    @Override
    public Employee saveEmployee(Employee employee) throws SQLException {
        return employeeDao.saveEmployee(employee);
    }
    @Override
    public Employee checkEmployeeId(String employeeId) throws SQLException {
        return employeeDao.checkEmployeeId(employeeId);
    }
}
