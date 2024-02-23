/**
 * This represents the User List Application.
 * This application allows users to view a list of users stored in a database.
 */
package com.view.user.list;

import com.view.user.list.app.facade.user.UserFacade;
import com.view.user.list.app.facade.user.Impl.UserFacadeImpl;
import com.view.user.list.app.model.user.User;


import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    // Constants representing menu options
    private static final int optionView = 1;
    private static final int optionExit = 2;

    /**
     * The main method initializes the application and displays the menu.
     * Users can choose to view the user list or exit the application.
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
                case optionView:
                    viewUserList(userFacade);
                    break;
                case optionExit:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please choose a valid option.");
            }

        } while (option != optionView);
    }

    /**
     * Displays the menu options for the User List Application.
     */
    private static void displayMenu() {
        System.out.println("----- User List Application -----");
        System.out.println("1. View User List");
        System.out.println("2. Exit");
        System.out.print("Choose an option: ");
    }

    /**
     * Displays the list of users retrieved from the database.
     *
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
