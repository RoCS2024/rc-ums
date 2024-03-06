package com.user.management.app.facade.student.Impl;

import com.user.management.app.facade.student.StudentFacade;
import com.user.management.app.model.student.Student;
import com.user.management.data.student.dao.StudentDao;
import com.user.management.data.student.dao.impl.StudentDaoImpl;

import java.sql.SQLException;

public class StudentFacadeImpl implements StudentFacade {
    private final StudentDao studentDao;

    public StudentFacadeImpl(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public StudentFacadeImpl() {
        this.studentDao = new StudentDaoImpl();
    }

    @Override
    public Student findStudentById(String studentId) throws SQLException {
        return studentDao.findStudentById(studentId);
    }

    @Override
    public Student saveStudent(Student student) throws SQLException {
        return studentDao.saveStudent(student);
    }
}
