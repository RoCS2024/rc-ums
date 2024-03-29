package com.user.management.appl.facade.student;


import com.user.management.appl.model.student.Student;

import java.sql.SQLException;
/**
 * This is the Student Facade.
 * */
public interface StudentFacade {
    Student findStudentById(String studentId);
    Student findStudentByEmail(String studentEmail);

    boolean saveStudent(Student student);

}