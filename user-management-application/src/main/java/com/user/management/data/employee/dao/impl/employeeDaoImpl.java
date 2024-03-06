package com.user.management.data.employee.dao.impl;


import com.user.management.app.model.employee.Employee;
import com.user.management.data.connection.ConnectionHelper;
import com.user.management.data.employee.dao.employeeDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class employeeDaoImpl implements employeeDao {

    @Override
    public Employee saveEmployee(Employee employee) throws SQLException {
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
            preparedStatement.setString(18, employee.getEmployeeNo());
            preparedStatement.executeUpdate();
        }
        return employee;
    }
    @Override
    public Employee checkEmployeeId(String employeeId) throws SQLException {
        String selectByIdQuery = "SELECT * FROM EMPLOYEE WHERE employee_no=?";
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
                    employee.setEmployeeNo(resultSet.getString("employee_no"));
                }
            }
        }
        return employee;
    }
}
