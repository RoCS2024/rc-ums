package com.view.user.list;

import com.view.user.list.app.facade.user.UserFacade;
import com.view.user.list.app.facade.user.Impl.UserFacadeImpl;
import com.view.user.list.app.model.user.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/**
 * The Main class represents the entry point of the User List Application.
 *
 */
public class Main {

    /**
     * The main method serves as the entry point of the application.
     * It displays a menu to the user and handles user input to perform actions accordingly.
     *
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserFacade userFacade = new UserFacadeImpl();

        int option;
        do {
            displayMenu();
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    viewUserList(userFacade);
                    break;
                case 2:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please choose a valid option.");
            }

        } while (option != 2);
    }

    /**
     * Displays the menu options to the user.
     */
    private static void displayMenu() {
        System.out.println("----- User List Application -----");
        System.out.println("1. View User List");
        System.out.println("2. Exit");
        System.out.print("Choose an option: ");
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
                System.out.println("User ID: " + user.getUserId());
                System.out.println("Username: " + user.getUserName());
                System.out.println("Entity ID: " + user.getEntityId());
                System.out.println("Date Created: " + user.getDateCreated());
                System.out.println("Date Modified: " + user.getDateModified());
                System.out.println();
            }
        } catch (SQLException e) {
            System.out.println("Error occurred while retrieving user list: " + e.getMessage());
        }
    }
}
