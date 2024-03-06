package com.user.management.data.student.dao;


import com.user.management.app.model.student.Student;

import java.sql.SQLException;

public interface StudentDao {
    Student saveStudent(Student student) throws SQLException;
    Student findStudentById(String studentId) throws SQLException;
}
