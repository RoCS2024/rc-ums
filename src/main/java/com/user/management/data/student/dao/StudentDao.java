package com.user.management.data.student.dao;


import com.user.management.appl.model.student.Student;

/**
 * This is the Student Dao.
 * */
public interface StudentDao {
    boolean saveStudent(Student student);
    Student findStudentById(String studentId);
     Student findStudentByEmail(String studentEmail);
}
