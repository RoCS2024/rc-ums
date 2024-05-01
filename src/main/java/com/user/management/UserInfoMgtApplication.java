package com.user.management;

import com.student.information.management.appl.facade.student.StudentFacade;
import com.employee.info.mgmt.appl.facade.employee.EmployeeFacade;
import com.employee.info.mgmt.appl.facade.employee.impl.EmployeeFacadeImpl;
import com.student.information.management.appl.facade.student.impl.StudentFacadeImpl;
import com.student.information.management.appl.facade.student.StudentFacade;
import com.user.management.appl.facade.user.UserFacade;
import com.user.management.appl.facade.user.impl.UserFacadeImpl;
import com.employee.info.mgmt.data.employee.dao.EmployeeDao;
import com.employee.info.mgmt.data.employee.dao.impl.EmployeeDaoImpl;
import com.student.information.management.data.student.dao.StudentDao;
import com.student.information.management.data.student.dao.impl.StudentDaoImpl;
import com.user.management.data.user.dao.UserDao;
import com.user.management.data.user.dao.impl.UserDaoImpl;

/**
 * This class will serve as the entry point for accessing various facades in the user management application
 */
public class UserInfoMgtApplication {
    private StudentFacade studentFacade;

    private EmployeeFacade employeeFacade;

    private UserFacade userFacade;

    /**
     * Get the UserFacade instance
     * @return The UserFacade instance
     */
    public UserFacade getUserFacade(){
        UserDao userDaoImpl = new UserDaoImpl();
        this.userFacade = new UserFacadeImpl(userDaoImpl);
        return userFacade;
    }

    /**
     * Get the StudentFacade instance
     * @return The StudentFacade instance
     */
    public StudentFacade getStudentFacade() {
        StudentDao studentDaoImpl = new StudentDaoImpl();
        this.studentFacade = new StudentFacadeImpl(studentDaoImpl);
        return  studentFacade;
    }

    /**
     * Get the EmployeeFacade instance
     * @return The EmployeeFacade instance
     */
    public EmployeeFacade getEmployeeFacade() {
        EmployeeDao employeeDaoImpl = new EmployeeDaoImpl();
        this.employeeFacade = new EmployeeFacadeImpl(employeeDaoImpl);
        return  employeeFacade;
    }
}
