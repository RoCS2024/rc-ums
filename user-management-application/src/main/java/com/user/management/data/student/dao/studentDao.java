package com.user.management.data.student.dao;


import com.user.management.app.model.student.Student;

import java.sql.SQLException;

public interface studentDao {
    Student saveStudent(Student student) throws SQLException;
    Student checkStudentId(String studentId) throws SQLException;
}
