package com.user.management.data.employee.dao.impl;


import com.user.management.app.model.employee.Employee;
import com.user.management.app.model.student.Student;
import com.user.management.data.connection.ConnectionHelper;
import com.user.management.data.employee.dao.EmployeeDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * This is the Employee Dao Impl.
 * */
public class EmployeeDaoImpl implements EmployeeDao {
    /**
     * This is for save employee.
     * */
    @Override
    public Employee saveEmployee(Employee employee) {
        String insertQuery = "INSERT INTO EMPLOYEE VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = ConnectionHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            preparedStatement.setString(1, employee.getLastName());
            preparedStatement.setString(2, employee.getFirstName());
            preparedStatement.setString(3, employee.getMiddleName());
            preparedStatement.setString(4, employee.getPositionInRc());
            preparedStatement.setTimestamp(5, employee.getDateEmployed());
            preparedStatement.setString(6, employee.getBirthdate());
            preparedStatement.setString(7, employee.getBirthplace());
            preparedStatement.setString(8, employee.getSex());
            preparedStatement.setString(9, employee.getCivilStatus());
            preparedStatement.setString(10, employee.getCitizenship());
            preparedStatement.setString(11, employee.getReligion());
            preparedStatement.setDouble(12, employee.getHeight());
            preparedStatement.setDouble(13, employee.getWeight());
            preparedStatement.setString(14, employee.getEmail());
            preparedStatement.setString(15, employee.getSssNo());
            preparedStatement.setString(16, employee.getTinNo());
            preparedStatement.setString(17, employee.getPagibigNo());
            preparedStatement.setString(18, employee.getEmployeeId());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return employee;
    }
    /**
     * This is for find employee by id.
     * */
    @Override
    public Employee findEmployeeById(String employeeId) {
        String selectByIdQuery = "SELECT * FROM EMPLOYEE WHERE employee_id=?";
        Employee employee = null;

        try (Connection connection = ConnectionHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectByIdQuery)) {
            preparedStatement.setString(1, employeeId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    employee = new Employee();
                    employee.setLastName(resultSet.getString("last_name"));
                    employee.setFirstName(resultSet.getString("first_name"));
                    employee.setMiddleName(resultSet.getString("middle_name"));
                    employee.setPositionInRc(resultSet.getString("position_in_rc"));
                    employee.setBirthdate(resultSet.getString("birthdate"));
                    employee.setBirthplace(resultSet.getString("birthplace"));
                    employee.setSex(resultSet.getString("sex"));
                    employee.setCivilStatus(resultSet.getString("civil_status"));
                    employee.setCitizenship(resultSet.getString("citizenship"));
                    employee.setReligion(resultSet.getString("religion"));
                    employee.setHeight(resultSet.getDouble("height"));
                    employee.setWeight(resultSet.getDouble("weight"));
                    employee.setEmail(resultSet.getString("email"));
                    employee.setSssNo(resultSet.getString("sss_no"));
                    employee.setTinNo(resultSet.getString("tin_no"));
                    employee.setPagibigNo(resultSet.getString("pagibig_no"));
                    employee.setEmployeeId(resultSet.getString("employee_id"));
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return employee;
    }

    @Override
    public Employee findEmployeeByEmail(String email) {
        String selectByIdQuery = "SELECT * FROM EMPLOYEE WHERE email=?";
        Employee employee = null;

        try (Connection connection = ConnectionHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectByIdQuery)) {
            preparedStatement.setString(1, email);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    employee = new Employee();
                    employee.setLastName(resultSet.getString("last_name"));
                    employee.setFirstName(resultSet.getString("first_name"));
                    employee.setMiddleName(resultSet.getString("middle_name"));
                    employee.setPositionInRc(resultSet.getString("position_in_rc"));
                    employee.setBirthdate(resultSet.getString("birthdate"));
                    employee.setBirthplace(resultSet.getString("birthplace"));
                    employee.setSex(resultSet.getString("sex"));
                    employee.setCivilStatus(resultSet.getString("civil_status"));
                    employee.setCitizenship(resultSet.getString("citizenship"));
                    employee.setReligion(resultSet.getString("religion"));
                    employee.setHeight(resultSet.getDouble("height"));
                    employee.setWeight(resultSet.getDouble("weight"));
                    employee.setEmail(resultSet.getString("email"));
                    employee.setSssNo(resultSet.getString("sss_no"));
                    employee.setTinNo(resultSet.getString("tin_no"));
                    employee.setPagibigNo(resultSet.getString("pagibig_no"));
                    employee.setEmployeeId(resultSet.getString("employee_id"));
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return employee;
    }
}
