package com.user.management.login.registers.app.facade.student.Impl;




import com.user.management.login.registers.app.facade.student.studentFacade;
import com.user.management.login.registers.app.model.login.Login;
import com.user.management.login.registers.app.model.student.Student;
import com.user.management.login.registers.data.student.dao.impl.studentDaoImpl;
import com.user.management.login.registers.data.student.dao.studentDao;

import java.sql.SQLException;

public class studentFacadeImpl implements studentFacade {
    private final studentDao studentDao;

    public studentFacadeImpl(studentDao studentDao) {
        this.studentDao = studentDao;
    }

    public studentFacadeImpl() {
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
