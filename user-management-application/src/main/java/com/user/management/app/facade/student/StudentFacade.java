package com.user.management.app.facade.student;


import com.user.management.app.model.student.Student;

import java.sql.SQLException;

public interface StudentFacade {
    Student findStudentById(String studentId) throws SQLException;
    Student saveStudent(Student student) throws SQLException;

}