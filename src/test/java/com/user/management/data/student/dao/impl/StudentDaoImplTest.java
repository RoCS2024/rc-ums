package com.user.management.data.student.dao.impl;

import com.user.management.appl.model.employee.Employee;
import com.user.management.appl.model.student.Student;
import com.user.management.data.connection.ConnectionHelper;
import com.user.management.data.student.dao.StudentDao;
import org.junit.jupiter.api.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * This is the Student Dao Impl Test.
 * */
class StudentDaoImplTest {

    private StudentDao studentDao;
    private List<Student> students;

    @BeforeEach
    public void setUp() {
        students = new ArrayList<>();
        Student student1 = new Student();
        Student student2 = new Student();
        students.add(student1);
        students.add(student2);

        studentDao = mock(StudentDao.class);
    }
    /**
     * This is to test get all students.
     */
    @Test
    public void testSaveStudents() {
        Student student = new Student();
        student.setStudentId("CT21-0073");

        when(studentDao.saveStudent(any(Student.class))).thenReturn(student);

        Student student1 = studentDao.saveStudent(student);

        assertEquals(student1.getStudentId(), "CT21-0073");
    }

    /**
     * This is to test find student by id.
     */
    @Test
    public void testFindStudentById() {
        Student student1 = new Student();
        student1.setStudentId("CT21-0073");

        when(studentDao.findStudentById("CT21-0073")).thenReturn(student1);

        Student expectedStudent = studentDao.findStudentById("CT21-0073");

        assertEquals(expectedStudent, student1);
        assertEquals(expectedStudent.getStudentId(), student1.getStudentId());
    }
    /**
     * This is to test find student by email.
     */
    @Test
    public void testFindStudentByEmail() {
        Student student1 = new Student();
        student1.setStudentId("CT21-0073");

        when(studentDao.findStudentByEmail("amulongkateann@gmail.com")).thenReturn(student1);

        Student expectedStudent = studentDao.findStudentByEmail("amulongkateann@gmail.com");

        assertEquals(expectedStudent, student1);
        assertEquals(expectedStudent.getStudentId(), student1.getStudentId());
    }
}
