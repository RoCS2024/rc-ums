package com.user.management.app.facade.student.Impl;

import com.user.management.app.model.student.Student;
import com.user.management.data.student.dao.studentDao;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StudentFacadeImplTest {

    @Test
    void testCheckStudentId() throws SQLException {

        String studentId = "CT21-0143";
        Student expectedStudent = new Student();
        expectedStudent.setStudentId(studentId);
        expectedStudent.setLastName("Magnaye");
        expectedStudent.setFirstName("Justine");

        studentDao studentDao = mock(studentDao.class);
        when(studentDao.checkStudentId(studentId)).thenReturn(expectedStudent);


        StudentFacadeImpl studentFacade = new StudentFacadeImpl(studentDao);
        Student result = studentFacade.checkStudentId(studentId);


        assertNotNull(result, "Returned student should not be null.");
        assertEquals(expectedStudent, result, "Returned student should match expected student.");
        verify(studentDao, times(1)).checkStudentId(studentId);
    }

    @Test
    void testSaveStudent() throws SQLException {

        Student student = new Student();
        student.setStudentId("CT21-0143");
        student.setLastName("Magnaye");
        student.setFirstName("Justine");

        studentDao studentDao = mock(studentDao.class);
        when(studentDao.saveStudent(student)).thenReturn(student);


        StudentFacadeImpl studentFacade = new StudentFacadeImpl(studentDao);
        Student result = studentFacade.saveStudent(student);

        assertNotNull(result, "Saved student should not be null.");
        assertEquals(student, result, "Saved student should match input student.");
        verify(studentDao, times(1)).saveStudent(student);
    }
}
