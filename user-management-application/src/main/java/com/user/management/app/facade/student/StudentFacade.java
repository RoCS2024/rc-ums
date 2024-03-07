package com.user.management.app.facade.student;


import com.user.management.app.model.student.Student;

import java.sql.SQLException;
/**
 * This is the Student Facade.
 * */
public interface StudentFacade {
    Student findStudentById(String studentId);

    Student saveStudent(Student student);
}