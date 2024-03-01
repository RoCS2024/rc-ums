package com.user.management.login.registers.data.student.dao;



import com.user.management.login.registers.app.model.login.Login;
import com.user.management.login.registers.app.model.student.Student;

import java.sql.SQLException;

public interface studentDao {
    Student saveStudent(Student student) throws SQLException;
    Student checkStudentId(String studentId) throws SQLException;
}
