package com.user.management.data.student.dao;


import com.user.management.app.model.student.Student;

import java.sql.SQLException;
/**
 * This is the Student Dao.
 * */
public interface StudentDao {
    Student saveStudent(Student student);
    Student findStudentById(String studentId);
}
