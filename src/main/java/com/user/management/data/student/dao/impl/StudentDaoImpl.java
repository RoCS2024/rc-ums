package com.user.management.data.student.dao.impl;


import com.user.management.appl.model.student.Student;
import com.user.management.data.connection.ConnectionHelper;
import com.user.management.data.student.dao.StudentDao;
import com.user.management.data.user.dao.impl.UserDaoImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * This is the Student Dao Impl.
 * */
public class StudentDaoImpl implements StudentDao {

    public static final Logger LOGGER = LoggerFactory.getLogger(StudentDaoImpl.class);
    /**
     * This is for save student.
     * */
        @Override
        public boolean saveStudent(Student student){
            boolean result = false;

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
                result = (rowsAffected > 0);
                if (rowsAffected > 0) {

                    LOGGER.info("Student inserted successfully.");
                } else {
                    LOGGER.warn("Failed to insert student.");
                }
            } catch (Exception e) {
                LOGGER.error("Error saving student.", e);
            }
            return result;
        }
    /**
     * This is for find student by id.
     * */
    @Override
    public Student findStudentById(String studentId){

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
        } catch (Exception e) {
            LOGGER.error("Error finding student by id.", e);
        }
        return student;
    }

    @Override
    public Student findStudentByEmail(String studentEmail){
        String selectByIdQuery = "SELECT * FROM STUDENT WHERE email=?";
        Student student = null;

        try (Connection connection = ConnectionHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectByIdQuery)) {
            preparedStatement.setString(1, studentEmail);
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
        } catch (Exception e) {
            LOGGER.error("Error finding student by email.", e);
        }
        return student;
    }
}

