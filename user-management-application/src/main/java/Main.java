import com.user.management.app.facade.employee.Impl.EmployeeFacadeImpl;
import com.user.management.app.facade.employee.EmployeeFacade;
import com.user.management.app.facade.user.impl.UserFacadeImpl;
import com.user.management.app.facade.user.UserFacade;
import com.user.management.app.facade.student.Impl.StudentFacadeImpl;
import com.user.management.app.facade.student.StudentFacade;
import com.user.management.app.model.employee.Employee;
import com.user.management.app.model.user.User;
import com.user.management.app.model.student.Student;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
/**
 * This class represents the main class for the login and registration system.
 */
public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final UserFacade userFacade = new UserFacadeImpl();
    private static final EmployeeFacade employeeFacade = new EmployeeFacadeImpl();
    private static final StudentFacade studentFacade = new StudentFacadeImpl();
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
                    viewUserList(userFacade);
                    break;
                case 2:
                    if(login()){
                        choice = 0;
                    }
                    break;
                case 3:
                    registerUser();
                    break;
                case 4:
                    updateUserInformation();
                    break;
                case 5:
                    updatePassword();
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
        System.out.println("1. View User List");
        System.out.println("2. Login");
        System.out.println("3. Register user");
        System.out.println("4. Update user");
        System.out.println("5. Change password");
        System.out.println("0. Exit");
    }

    /**
     * Displays the list of users to the console.
     * Retrieves user data using the provided UserFacade and prints it.
     *
     * @param userFacade The facade object used to interact with user data.
     */
    private static void viewUserList(UserFacade userFacade) {
        try {
            List<User> userList = userFacade.getAllUsers();
            System.out.println("----- User List -----");
            for (User user : userList) {
                System.out.println("User ID: " + user.getId());
                System.out.println("Username: " + user.getUsername());
                System.out.println("Entity ID: " + user.getEntity_id());
                System.out.println("Date Created: " + user.getDate_created());
                System.out.println("Date Modified: " + user.getDate_modified());
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println("Error occurred while retrieving user list: " + e.getMessage());
        }
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
            User currentUser = userFacade.findUserByUsernameAndPassword(username, password);
            if (currentUser != null && password.equals(currentUser.getPassword())) {
                System.out.println("Login Successful");
                return true;
            } else {
                System.out.println("Login failed. Please check your username and password.");
                return false;
            }
        } catch (Exception e) {
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
            User currentUser = userFacade.findUserByUsernameAndPassword(username,password);
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
                            while (studentFacade.findStudentById(studentId) != null) {
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
                            while (employeeFacade.findEmployeeById(eNo) != null) {
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
                            employee.setEmployeeId(eNo);
                            employee = employeeFacade.saveEmployee(employee);
                            check = 1;
                            break;
                        default:
                            System.out.println("Invalid Input! Please re-enter your input");
                            break;
                    }
                }while(check == 0);
                User user = new User();
                user.setUsername(username);
                user.setPassword(password);
                user = userFacade.saveUser(user);
                System.out.println("Registered Successfully");

            } else {
                System.out.println("Username already taken!");
            }
        } catch (Exception e) {
            System.out.println("Error registering user. Please try again.");
        }
    }
    private static void updateUserInformation() {
        try {
            int userId = 0;
            do {
                System.out.print("Enter User-ID: ");
                if (!scanner.hasNextInt()) {
                    System.out.println("Invalid input. Please enter an integer.");
                    scanner.next();
                    continue;
                }
                userId = scanner.nextInt();
                if (userId < 0) {
                    System.out.println("Invalid user ID. Please enter a non-negative integer.");
                    continue;
                }

                System.out.print("Enter New Username: ");
                String username = scanner.next();

                if (username.isEmpty()) {
                    System.out.println("Username cannot be empty.");
                    return;
                }

                System.out.print("Enter New Password: ");
                String password = scanner.next();

                if (password.isEmpty()) {
                    System.out.println("Password cannot be empty.");
                    return;
                }

                System.out.print("Enter New Entity-ID: ");
                String entityId = scanner.next();

                if (entityId.isEmpty()) {
                    System.out.println("Entity ID cannot be empty.");
                    return;
                }

                User existingUser = userFacade.getUserById(userId);
                if (existingUser != null) {
                    existingUser.setUsername(username);
                    existingUser.setPassword(password);
                    existingUser.setEntity_id(entityId);
                    existingUser.setDate_modified(new Timestamp(System.currentTimeMillis()));

                    boolean updated = userFacade.updateUser(existingUser);

                    if (updated) {
                        System.out.println("User information updated successfully!");
                    } else {
                        System.out.println("Failed to update user information.");
                    }
                } else {
                    System.out.println("User with ID " + userId + " does not exist.");
                }

            } while (userId != 0);

        } catch (Exception e) {
            System.err.println("An error occurred while updating user information: " + e.getMessage());
        }
    }
    private static void updatePassword() {
        try {
            System.out.print("Enter username: ");
            String username = scanner.next();

            User existingUser = userFacade.getUsername(username);

            if (existingUser != null) {

                System.out.print("Enter current password: ");
                String enteredPassword = scanner.next();

                if(enteredPassword.equals(existingUser.getPassword())) {

                    System.out.print("Enter new password: ");
                    String newPasswordd = scanner.next();
                    System.out.print("Confirm new password: ");
                    String newPassword = scanner.next();

                    if(newPasswordd.equals(newPassword)) {
                        System.out.println("password");
                        existingUser.setPassword(newPassword);
                        Timestamp currentTimestamp = new Timestamp(new Date().getTime());
                        existingUser.setDate_modified(currentTimestamp);
                        userFacade.updatePassword(existingUser);

                        System.out.println("Password updated successfully.");

                    } else System.out.println("Password does not match.");

                } else System.out.println("Incorrect password. Password update failed.");

            } else System.out.println(username + " not found. Please input a valid username.");

        } catch (Exception e) {
            System.out.println("Error updating password. Please try again.");
        }
    }
}
