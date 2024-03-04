package com.user.management.login.registers.data.student.dao.impl;



import com.user.management.login.registers.app.model.login.Login;
import com.user.management.login.registers.app.model.student.Student;
import com.user.management.login.registers.data.connection.ConnectionHelper;
import com.user.management.login.registers.data.student.dao.studentDao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class studentDaoImpl implements studentDao {

        @Override
        public Student saveStudent(Student student) throws SQLException {
            String insertQuery = "INSERT INTO STUDENT VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            try (Connection connection = ConnectionHelper.getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setString(1, student.getStudentId());
                preparedStatement.setString(2, student.getLastName());
                preparedStatement.setString(3, student.getFirstName());
                preparedStatement.setString(4, student.getMiddleName());
                preparedStatement.setString(5, student.getSex());
                preparedStatement.setString(6, student.getBirthday());
                preparedStatement.setString(7, student.getReligion());
                preparedStatement.setString(8, student.getEmail());
                preparedStatement.setString(9, student.getAddress());
                preparedStatement.setString(10, student.getContactNumber());

                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Student inserted successfully.");
                } else {
                    System.out.println("Failed to insert student.");
                }
            } catch (SQLException e) {
                System.out.println("Error inserting student: " + e.getMessage());
                throw e; // rethrow the exception to indicate failure
            }

            return student;
        }

    @Override
    public Student checkStudentId(String studentId) throws SQLException {
        String selectByIdQuery = "SELECT * FROM STUDENT WHERE student_id=?";
        Student student = null;

        try (Connection connection = ConnectionHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectByIdQuery)) {
            preparedStatement.setString(1, studentId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    student = new Student();
                    student.setStudentId(resultSet.getString("student_id"));
                    student.setLastName(resultSet.getString("last_name"));
                    student.setFirstName(resultSet.getString("first_name"));
                    student.setMiddleName(resultSet.getString("middle_name"));
                    student.setSex(resultSet.getString("sex"));
                    student.setBirthday(resultSet.getString("birthday"));
                    student.setReligion(resultSet.getString("religion"));
                    student.setEmail(resultSet.getString("email"));
                    student.setAddress(resultSet.getString("address"));
                    student.setContactNumber(resultSet.getString("contact_number"));
                }
            }
        }
        return student;
    }
}
