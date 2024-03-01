/**
 * This is the Main class.
 * this class is the entry point of all methods and classes.
 * */

package com.user.management;

import com.user.management.app.facade.user.UserFacade;
import com.user.management.app.facade.user.impl.UserFacadeImpl;
import com.user.management.app.model.user.User;

import com.user.management.data.user.dao.impl.UserDaoImpl;

import java.sql.Timestamp;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final UserFacade userFacade = new UserFacadeImpl(new UserDaoImpl());

    public static void main(String[] args) {
        try {
            int choice;
            do {
                displayMenu();
                System.out.print("Choose an option: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        updateUserInformation();
                        break;
                    case 0:
                        System.out.println("Exiting the App...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                        break;
                }
            } while (choice != 0);
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static void displayMenu() {
        System.out.println("User Management Application");
        System.out.println("1. Update User Information");
        System.out.println("0. Exit");
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
                }
            } while (userId < 0);

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
        } catch (Exception e) {
            System.err.println("An error occurred while updating user information: " + e.getMessage());
        }
    }

}
