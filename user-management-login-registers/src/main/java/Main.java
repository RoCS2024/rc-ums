import com.user.management.login.registers.app.facade.login.Impl.loginFacadeImpl;
import com.user.management.login.registers.app.facade.login.loginFacade;
import com.user.management.login.registers.app.model.login.Login;
import com.user.management.login.registers.data.login.dao.impl.loginDaoImpl;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final loginFacade loginFacade = new loginFacadeImpl(new loginDaoImpl());

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

    private static void displayMenu() {
        System.out.println("Login Options");
        System.out.println("1. Login");
        System.out.println("2. Register user");
        System.out.println("0. Exit");
    }

    private static boolean login() {
        try {
            System.out.print("Enter Username: ");
            String username = scanner.next();
            System.out.print("Enter Password: ");
            String password = scanner.next();
            Login login = loginFacade.checkUsername(username, password);
            if (login != null && password.equals(login.getPassword())) {
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

    private static void registerUser() {
        try {
            System.out.print("Enter Username: ");
            String username = scanner.next();
            System.out.print("Enter Password: ");
            String password = scanner.next();
            boolean registered = loginFacade.registerUser(username, password);
            if (registered) {
                System.out.println("User registered successfully.");
            } else {
                System.out.println("Failed to register user. Please try again.");
            }
        } catch (SQLException e) {
            System.out.println("Error registering user. Please try again.");
        }
    }
}
