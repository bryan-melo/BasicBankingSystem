package src.main.java;

import src.database.DatabaseConnection;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nWelcome to the basic.java.banking system!");
        MainMenuController.displayMainMenu();
        int input = scanner.nextInt();

        while (true) {
            switch (input) {
                case 1:
                    MainMenuController.createNewAccount();
                    break;
                case 2:
                    MainMenuController.depositIntoAccount();
                    break;
                case 3:
                    MainMenuController.withdrawFromAccount();
                    break;
                case 4:
                    MainMenuController.checkAccountBalance();
                    break;
                case 5:
                    MainMenuController.removeAccount();
                    break;
                case 6:
                    System.out.println("\nThank you for using the basic src.main.java.banking system!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
            MainMenuController.displayMainMenu();
            input = scanner.nextInt();
        }
    }
}