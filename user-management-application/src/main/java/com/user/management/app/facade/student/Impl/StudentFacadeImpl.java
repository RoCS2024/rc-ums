package com.user.management.app.facade.student.Impl;


import com.user.management.app.facade.student.StudentFacade;
import com.user.management.app.model.student.Student;
import com.user.management.data.student.dao.impl.studentDaoImpl;

import java.sql.SQLException;

public class StudentFacadeImpl implements StudentFacade {
    private final com.user.management.data.student.dao.studentDao studentDao;

    public StudentFacadeImpl(com.user.management.data.student.dao.studentDao studentDao) {
        this.studentDao = studentDao;
    }

    public StudentFacadeImpl() {
        this.studentDao = new studentDaoImpl();
    }
    @Override
    public Student checkStudentId(String studentId) throws SQLException {
        return studentDao.checkStudentId(studentId);
    }
    @Override
    public Student saveStudent(Student student) throws SQLException {
        return studentDao.saveStudent(student);
    }
}
