import com.change.password.app.facade.login.LoginFacade;
import com.change.password.app.facade.login.impl.LoginFacadeImpl;
import com.change.password.app.model.login.Login;
import com.change.password.data.login.dao.impl.LoginDaoImpl;

import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final LoginDaoImpl loginDao = new LoginDaoImpl() {
        @Override
        public List<Login> getUsername() {
            return null;
        }

        @Override
        public Login updatePassword(String number) {
            return null;
        }
    };
    private static final LoginFacade loginFacade = new LoginFacadeImpl();

    public static void main(String[] args) {
        System.out.println("\nUSER PASSWORD MANAGER");
        int choice;
        do {
            displayMenu();
            System.out.print("\nChoose an option: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    updatePassword();
                    break;
                case 0:
                    System.out.println("Shutting down...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        } while (choice != 0);
        sc.close();
    }

    private static void displayMenu() {
        System.out.println("\n1. Change password");
        System.out.println("0. Exit");
    }

    private static void updatePassword() {
        try {
            System.out.print("Enter username: ");
            String username = sc.next();

            Login existingUser = loginFacade.getUsername(username);

            if (existingUser != null) {

                System.out.print("Enter current password: ");
                String enteredPassword = sc.next();

                if(enteredPassword.equals(existingUser.getPassword())) {

                    System.out.print("Enter new password: ");
                    String newPasswordd = sc.next();
                    System.out.print("Confirm new password: ");
                    String newPassword = sc.next();

                    if(newPasswordd.equals(newPassword)) {

                        existingUser.setPassword(newPassword);
                        Timestamp currentTimestamp = new Timestamp(new Date().getTime());
                        existingUser.setDateModified(currentTimestamp);
                        loginFacade.updatePassword(existingUser);

                        System.out.println("Password updated successfully.");

                    } else System.out.println("Password does not match.");

                } else System.out.println("Incorrect password. Password update failed.");

            } else System.out.println(username + " not found. Please input a valid username.");

        } catch (SQLException e) {
            System.out.println("Error updating password. Please try again.");
            e.printStackTrace();
        }
    }
}