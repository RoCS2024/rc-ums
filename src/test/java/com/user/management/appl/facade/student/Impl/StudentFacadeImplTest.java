package com.user.management.appl.facade.student.Impl;

import com.user.management.appl.facade.student.StudentFacade;
import com.user.management.appl.model.student.Student;
import com.user.management.data.student.dao.StudentDao;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.InjectMocks;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
/**
 * This is the Student Facade Impl Test.
 * */
class StudentFacadeImplTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(StudentFacadeImplTest.class);

    @InjectMocks
    private StudentFacade studentFacade;

    @Mock
    private StudentDao studentDao;

    @Mock
    private List<Student> studentList;

    @Mock
    private Student student;

    @Mock
    private Student addStudent;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        student.setStudentId("1");
        addStudent.setStudentId("2");
        when(studentDao.saveStudent(student)).thenReturn(true);
    }

    @AfterEach
    public void validate() {
        validateMockitoUsage();
    }


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
        when(studentDao.saveStudent(student)).thenReturn(true);


        StudentFacadeImpl studentFacade = new StudentFacadeImpl(studentDao);
        boolean result = studentFacade.saveStudent(student);

        assertNotNull(result, "Saved student should not be null.");
        assertEquals(result,true);
        verify(studentDao, times(1)).saveStudent(student);
    }

    @Test
    public void testUpdateStudent() {
        StudentDao studentDao = mock(StudentDao.class);
        when(studentDao.saveStudent(student)).thenReturn(true);

        StudentFacadeImpl studentFacade = new StudentFacadeImpl(studentDao);
        boolean result = studentFacade.saveStudent(student);

        // Assert that when updating an item, it returns true if successful
        assert(result);
        // Verify that itemDao.updateItem() is called when itemFacade.updateItem() is invoked
        verify(studentDao).saveStudent(student);

    }
}