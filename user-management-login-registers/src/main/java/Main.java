import com.user.management.login.registers.app.facade.employee.Impl.employeeFacadeImpl;
import com.user.management.login.registers.app.facade.employee.employeeFacade;
import com.user.management.login.registers.app.facade.login.Impl.loginFacadeImpl;
import com.user.management.login.registers.app.facade.login.loginFacade;
import com.user.management.login.registers.app.facade.student.Impl.studentFacadeImpl;
import com.user.management.login.registers.app.facade.student.studentFacade;
import com.user.management.login.registers.app.model.employee.Employee;
import com.user.management.login.registers.app.model.login.Login;
import com.user.management.login.registers.app.model.student.Student;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Scanner;
/**
 * This class represents the main class for the login and registration system.
 */
public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final loginFacade loginFacade = new loginFacadeImpl();
    private static final employeeFacade employeeFacade = new employeeFacadeImpl();
    private static final studentFacade studentFacade = new studentFacadeImpl();
    /**
     * The entry point of the application.
     * param args The command line arguments.
     */
    public static void main(String[] args) {
        int choice;
        do {
            displayMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    if(login()){
                        choice = 0;
                    }
                    break;
                case 2:
                    registerUser();
                    break;
                case 0:
                    System.out.println("Exiting the Login System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        } while (choice != 0);
    }
    /**
     * Displays the main menu options.
     */
    private static void displayMenu() {
        System.out.println("Login Options");
        System.out.println("1. Login");
        System.out.println("2. Register user");
        System.out.println("0. Exit");
    }
    /**
     * Handles the login functionality.
     * return True if login is successful, otherwise false.
     */
    private static boolean login() {
        try {
            System.out.print("Enter Username: ");
            String username = scanner.next();
            System.out.print("Enter Password: ");
            String password = scanner.next();
            Login currentUser = loginFacade.checkUsername(username, password);
            if (currentUser != null && password.equals(currentUser.getPassword())) {
                System.out.println("Login Successful");
                return true;
            } else {
                System.out.println("Login failed. Please check your username and password.");
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Error fetching login details. Please try again.");
            return false;
        }
    }
    /**
     * Handles the user registration process.
     */
    private static void registerUser() {
        try {
            System.out.print("Enter Username: ");
            String username = scanner.next();
            System.out.print("Enter Password: ");
            String password = scanner.next();
            Login currentUser = loginFacade.checkUsername(username,password);
            if(currentUser == null){
                int check = 0;
                do {
                    System.out.println("Are you a student or employee?");
                    System.out.println("Type (\"Student\" or \"Employee\")");
                    String type = scanner.next();
                    String ltype = type.toLowerCase();
                    switch(ltype){
                        case "student":
                            System.out.println("Student Form: ");
                            System.out.println("Enter Student Id: ");
                            String studentId = scanner.next();
                            while (studentFacade.checkStudentId(studentId) != null) {
                                System.out.println("Student Id Already Exist!");
                                System.out.println("Enter a new Student Id: ");
                                studentId = scanner.next();
                            }
                            System.out.println("Enter Last Name: ");
                            String lastName = scanner.next();
                            System.out.println("Enter First Name: ");
                            String firstName = scanner.next();
                            System.out.println("Enter Middle Initial: ");
                            String middleName = scanner.next();
                            System.out.println("Enter Sex: ");
                            String studentSex = scanner.next();
                            System.out.println("Enter Birthday (MM/DD/YYYY): ");
                            String studentBirthday = scanner.next();
                            while (!Student.isValidBirthday(studentBirthday)) {
                                System.out.println("Invalid birthday format!");
                                System.out.println("Enter Birthday (MM/DD/YYYY): ");
                                studentBirthday = scanner.next();
                            }
                            System.out.println("Enter Religion: ");
                            String studentReligion = scanner.next();
                            System.out.println("Enter Email Address: ");
                            String studentEmail = scanner.next();
                            System.out.println("Enter Address: ");
                            String studentAddress = scanner.next();
                            System.out.println("Enter Contact No: ");
                            String studentContactNo = scanner.next();
                            Student student = new Student();
                            student.setStudentId(studentId);
                            student.setLastName(lastName);
                            student.setFirstName(firstName);
                            student.setMiddleName(middleName);
                            student.setSex(studentSex);
                            student.setBirthday(studentBirthday);
                            student.setReligion(studentReligion);
                            student.setEmail(studentEmail);
                            student.setAddress(studentAddress);
                            student.setContactNumber(studentContactNo);
                            student = studentFacade.saveStudent(student);
                            check = 1;
                            break;
                        case "employee":
                            System.out.println("Employee Form: ");
                            System.out.println("Enter Last Name: ");
                            String lname = scanner.next();
                            System.out.println("Enter First Name: ");
                            String fname = scanner.next();
                            System.out.println("Enter Middle Initial: ");
                            String mname = scanner.next();
                            System.out.println("Enter Position In RC: ");
                            String rcPos = scanner.next();
                            System.out.println("Enter Birthdate (MM/DD/YYYY): ");
                            String birthDate = scanner.next();
                            while (!Student.isValidBirthday(birthDate)) {
                                System.out.println("Invalid birthday format!");
                                System.out.println("Enter Birthday (MM/DD/YYYY): ");
                                birthDate = scanner.next();
                            }
                            System.out.println("Enter Birthplace: ");
                            String birthPlace = scanner.next();
                            System.out.println("Enter Sex: ");
                            String sex = scanner.next();
                            System.out.println("Enter Civil Status: ");
                            String civilStatus = scanner.next();
                            System.out.println("Enter Citizenship: ");
                            String citizenship = scanner.next();
                            System.out.println("Enter Religion: ");
                            String religion = scanner.next();
                            System.out.println("Enter Height: ");
                            double height = scanner.nextDouble();
                            System.out.println("Enter Weight: ");
                            double weight = scanner.nextDouble();
                            System.out.println("Enter Email: ");
                            String email = scanner.next();
                            System.out.println("Enter SSS No: ");
                            String sssNo = scanner.next();
                            System.out.println("Enter Tin Number: ");
                            String tNumber = scanner.next();
                            System.out.println("Enter Pagibig No: ");
                            String pagibigNo = scanner.next();
                            System.out.println("Enter Employee No: ");
                            String eNo = scanner.next();
                            while (employeeFacade.checkEmployeeId(eNo) != null) {
                                System.out.println("Employee No. Already Exist!");
                                System.out.println("Enter a new Employee No: ");
                                eNo = scanner.next();
                            }
                            Employee employee = new Employee();
                            employee.setLastName(lname);
                            employee.setFirstName(fname);
                            employee.setMiddleName(mname);
                            employee.setPositionInRc(rcPos);
                            Timestamp currentTimestamp = new Timestamp(new Date().getTime());
                            employee.setDateEmployed(currentTimestamp);
                            employee.setBirthdate(birthDate);
                            employee.setBirthplace(birthPlace);
                            employee.setSex(sex);
                            employee.setCivilStatus(civilStatus);
                            employee.setCitizenship(citizenship);
                            employee.setReligion(religion);
                            employee.setHeight(height);
                            employee.setWeight(weight);
                            employee.setEmail(email);
                            employee.setSssNo(sssNo);
                            employee.setTinNo(tNumber);
                            employee.setPagibigNo(pagibigNo);
                            employee.setEmployeeNo(eNo);
                            employee = employeeFacade.saveEmployee(employee);
                            check = 1;
                            break;
                        default:
                            System.out.println("Invalid Input! Please re-enter your input");
                            break;
                    }
                }while(check == 0);
                Login login = new Login();
                login.setUsername(username);
                login.setPassword(password);
                login = loginFacade.saveUser(login);
                System.out.println("Registered Successfully");

            } else {
                System.out.println("Username already taken!");
            }
        } catch (SQLException e) {
            System.out.println("Error registering user. Please try again.");
        }
    }
}
