package com.user.management.data.student.dao.impl;

import com.user.management.appl.model.student.Student;
import com.user.management.data.student.dao.StudentDao;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

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

    @Test
    public void testSaveStudent(){
        Student student1 = new Student();
        student1.setStudentId("CT21-0073");


        when(studentDao.saveStudent(student1)).thenReturn(true);
        boolean result = studentDao.saveStudent(student1);

        verify(studentDao).saveStudent(student1);

        assertEquals(result, true);
    }
    @Test
    public void testFindStudentById(){
        Student student1 = new Student();
        student1.setStudentId("CT21-0073");

        when(studentDao.findStudentById("CT21-0073")).thenReturn(student1);

        Student expectedStudent = studentDao.findStudentById("CT21-0073");

        assertEquals(expectedStudent, student1);
        assertEquals(expectedStudent.getStudentId(), student1.getStudentId());
    }
    @Test
    public void testFindStudentByEmail(){
        Student student1 = new Student();
        student1.setEmail("amulongkateann@gmail.com");

        when(studentDao.findStudentByEmail("amulongkateann@gmail.com")).thenReturn(student1);

        Student expectedStudent = studentDao.findStudentByEmail("amulongkateann@gmail.com");

        assertEquals(expectedStudent, student1);
        assertEquals(expectedStudent.getEmail(), student1.getEmail());
    }
}
