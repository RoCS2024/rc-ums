import com.user.management.appl.facade.employee.EmployeeFacade;
import com.user.management.appl.facade.employee.Impl.EmployeeFacadeImpl;
import com.user.management.appl.facade.student.Impl.StudentFacadeImpl;
import com.user.management.appl.facade.student.StudentFacade;
import com.user.management.appl.facade.user.UserFacade;
import com.user.management.appl.facade.user.impl.UserFacadeImpl;
import com.user.management.data.employee.dao.EmployeeDao;
import com.user.management.data.employee.dao.impl.EmployeeDaoImpl;
import com.user.management.data.student.dao.StudentDao;
import com.user.management.data.student.dao.impl.StudentDaoImpl;
import com.user.management.data.user.dao.UserDao;
import com.user.management.data.user.dao.impl.UserDaoImpl;

public class UserInfoMgtApplication {
    private StudentFacade studentFacade;

    private EmployeeFacade employeeFacade;

    private UserFacade userFacade;

    public UserFacade UserInfoMgtApplication(){

        UserDao userDaoImpl = new UserDaoImpl();
        this.userFacade = new UserFacadeImpl(userDaoImpl);
        return userFacade;



    }
    public StudentFacade getStudentFacade() {
        StudentDao studentDaoImpl = new StudentDaoImpl();
        this.studentFacade = new StudentFacadeImpl(studentDaoImpl);
        return  studentFacade;
    }

    public EmployeeFacade getEmployeeFacade() {
        EmployeeDao employeeDaoImpl = new EmployeeDaoImpl();
        this.employeeFacade = new EmployeeFacadeImpl(employeeDaoImpl);
        return  employeeFacade;
    }


}


