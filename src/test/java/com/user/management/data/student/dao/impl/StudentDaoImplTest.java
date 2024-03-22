package com.user.management.data.student.dao.impl;

import com.user.management.app.model.student.Student;
import com.user.management.data.connection.ConnectionHelper;
import com.user.management.data.student.dao.StudentDao;
import org.junit.jupiter.api.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
/**
 * This is the Student Dao Impl Test.
 * */
class StudentDaoImplTest {

    private static StudentDao studentDao;

    @BeforeAll
    static void setUp() {
        studentDao = new StudentDaoImpl();
    }

    @Test
    void saveStudent_ValidStudent_ReturnsStudentWithId() {
        try {
            Student testStudent = new Student();
            testStudent.setStudentId("CT21-143");
            testStudent.setLastName("Magnaye");
            testStudent.setFirstName("Justine");
            testStudent.setMiddleName("Dave");
            testStudent.setSex("Male");
            testStudent.setBirthday("02/25/2002");
            testStudent.setReligion("Christian");
            testStudent.setEmail("jdee@example.com");
            testStudent.setAddress("123 Pulong Bunga");
            testStudent.setContactNumber("1234567890");

            Student savedStudent = studentDao.saveStudent(testStudent);

            assertNotNull(savedStudent.getStudentId());
            assertEquals(testStudent.getLastName(), savedStudent.getLastName());
            assertEquals(testStudent.getFirstName(), savedStudent.getFirstName());
            assertEquals(testStudent.getMiddleName(), savedStudent.getMiddleName());
            assertEquals(testStudent.getSex(), savedStudent.getSex());
            assertEquals(testStudent.getBirthday(), savedStudent.getBirthday());
            assertEquals(testStudent.getReligion(), savedStudent.getReligion());
            assertEquals(testStudent.getEmail(), savedStudent.getEmail());
            assertEquals(testStudent.getAddress(), savedStudent.getAddress());
            assertEquals(testStudent.getContactNumber(), savedStudent.getContactNumber());
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }


    @Test
    void checkStudentId_ValidStudentId_ReturnsStudent() {
        String studentId = "CT21-0144";
        try (Connection connection = ConnectionHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO STUDENT (student_id, last_name, first_name, middle_name, sex, birthday, religion, email, address, contact_number) VALUES (?, ?, ?, ?, ?, TO_DATE(?, 'MM/DD/YYYY'), ?, ?, ?, ?)")) {
            preparedStatement.setString(1, studentId);
            preparedStatement.setString(2, "Magnaye");
            preparedStatement.setString(3, "Justine");
            preparedStatement.setString(4, "Dave");
            preparedStatement.setString(5, "Male");
            preparedStatement.setString(6, "2003-02-02"); // Correct date format (MM/DD/YYYY)
            preparedStatement.setString(7, "Christian");
            preparedStatement.setString(8, "jdee@example.com");
            preparedStatement.setString(9, "123 Pulong Bunga");
            preparedStatement.setString(10, "1234567890");
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            fail("Error inserting test data: " + e.getMessage());
        }
        try {
            Student retrievedStudent = studentDao.findStudentById(studentId);

            assertNotNull(retrievedStudent);
            assertEquals(studentId, retrievedStudent.getStudentId());
            assertEquals("Magnaye", retrievedStudent.getLastName());
            assertEquals("Justine", retrievedStudent.getFirstName());
            assertEquals("Dave", retrievedStudent.getMiddleName());
            assertEquals("Male", retrievedStudent.getSex());
            assertEquals("2003-02-02", retrievedStudent.getBirthday());
            assertEquals("Christian", retrievedStudent.getReligion());
            assertEquals("jdee@example.com", retrievedStudent.getEmail());
            assertEquals("123 Pulong Bunga", retrievedStudent.getAddress());
            assertEquals("1234567890", retrievedStudent.getContactNumber());
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        } finally {
            try (Connection connection = ConnectionHelper.getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(
                         "DELETE FROM STUDENT WHERE student_id = ?")) {
                preparedStatement.setString(1, studentId);
                preparedStatement.executeUpdate();
            } catch (Exception e) {
                fail("Error cleaning up test data: " + e.getMessage());
            }
        }
    }
}
