package com.user.management.appl.facade.student.Impl;

import com.user.management.appl.facade.student.StudentFacade;
import com.user.management.appl.model.student.Student;
import com.user.management.data.student.dao.StudentDao;
import com.user.management.data.student.dao.impl.StudentDaoImpl;

/**
 * This is an implementation class of the StudentFacade
 */
public class StudentFacadeImpl implements StudentFacade {
    private final StudentDao studentDao;


    /**
     * This is a constructor for the StudentFacadeImpl with a custom StudentDao .
     *
     * @param studentDao The StudentDao implementation used for database operations.
     */
    public StudentFacadeImpl(StudentDao studentDao) {
        this.studentDao = studentDao;
    }


    /**
     * This is a constructor for the StudentFacadeImpl with the default StudentDaoImpl .
     * This constructor initializes the StudentDao internally.
     */
    public StudentFacadeImpl() {
        this.studentDao = new StudentDaoImpl();
    }

    @Override
    public Student findStudentById(String studentId) {
        return studentDao.findStudentById(studentId);
    }

    @Override
    public Student findStudentByEmail(String studentEmail) {
        return studentDao.findStudentByEmail(studentEmail);
    }

    @Override
    public boolean saveStudent(Student student) {
        return studentDao.saveStudent(student);
    }
}
