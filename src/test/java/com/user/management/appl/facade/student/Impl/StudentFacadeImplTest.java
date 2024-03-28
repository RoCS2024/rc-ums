package com.user.management.appl.facade.student.Impl;

import com.user.management.appl.model.student.Student;
import com.user.management.data.student.dao.StudentDao;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * This is the Student Facade Impl Test.
 * */
class StudentFacadeImplTest {

    @Test
    void testCheckStudentId() {

        String studentId = "CT21-0143";
        Student expectedStudent = new Student();
        expectedStudent.setStudentId(studentId);
        expectedStudent.setLastName("Magnaye");
        expectedStudent.setFirstName("Justine");

        StudentDao studentDao = mock(StudentDao.class);
        when(studentDao.findStudentById(studentId)).thenReturn(expectedStudent);


        StudentFacadeImpl studentFacade = new StudentFacadeImpl(studentDao);
        Student result = studentFacade.findStudentById(studentId);


        assertNotNull(result, "Returned student should not be null.");
        assertEquals(expectedStudent, result, "Returned student should match expected student.");
        verify(studentDao, times(1)).findStudentById(studentId);
    }

    @Test
    void testSaveStudent() {

        Student student = new Student();
        student.setStudentId("CT21-0143");
        student.setLastName("Magnaye");
        student.setFirstName("Justine");

        StudentDao studentDao = mock(StudentDao.class);
        when(studentDao.saveStudent(student)).thenReturn(student);


        StudentFacadeImpl studentFacade = new StudentFacadeImpl(studentDao);
        Student result = studentFacade.saveStudent(student);

        assertNotNull(result, "Saved student should not be null.");
        assertEquals(student, result, "Saved student should match input student.");
        verify(studentDao, times(1)).saveStudent(student);
    }

    public void testFindStudentByEmail(){
        Student student = new Student ();
        student.setEmail("amulongkateann@gmail.com");

        when(StudentDao.findStudentByEmail("amulongkateann@gmail.com")).thenReturn(student);

        Student expectedStudent = StudentDao.findStudentByEmail("amulongkateann@gmail.com");

        assertEquals(expectedStudent, student);
        assertEquals(expectedStudent.getEmail(), student.getEmail());
}
