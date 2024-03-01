package com.user.management.login.registers.app.facade.student;



import com.user.management.login.registers.app.model.login.Login;
import com.user.management.login.registers.app.model.student.Student;

import java.sql.SQLException;

public interface studentFacade {
    Student checkStudentId(String studentId) throws SQLException;
    Student saveStudent(Student student) throws SQLException;

}