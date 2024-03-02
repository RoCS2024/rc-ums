package com.user.management.login.registers.app.facade.employee.Impl;


import com.user.management.login.registers.app.facade.employee.employeeFacade;
import com.user.management.login.registers.app.model.employee.Employee;
import com.user.management.login.registers.app.model.student.Student;
import com.user.management.login.registers.data.employee.dao.employeeDao;
import com.user.management.login.registers.data.employee.dao.impl.employeeDaoImpl;


import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
public class employeeFacadeImpl implements employeeFacade {
    private final employeeDao employeeDao;

    public employeeFacadeImpl(employeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public employeeFacadeImpl() {
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
