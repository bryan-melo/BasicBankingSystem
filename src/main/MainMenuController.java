package src.main;

import src.main.banking.Account;
import src.main.banking.Bank;

import java.util.Scanner;

public class MainMenuController {
    static Scanner scanner = new Scanner(System.in);
    static Bank bank = new Bank();

    // Displays main menu that is displayed after each option has been completed
    public static void displayMainMenu() {
        System.out.println("\n===================");
        System.out.println("    src.main.Main menu    ||");
        System.out.println("===================\n");
        System.out.println("1. Create Account");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Check Balance");
        System.out.println("5. Delete Account");
        System.out.println("6. Exit\n");
        System.out.print("ENTER: 1 - 6: ");
    }

    // Displays create account procedures
    public static void createNewAccount() {
        String name;
        double amount;

        System.out.println("\n======================");
        System.out.println("   Create Account   ||");
        System.out.println("======================\n");

        System.out.print("Enter name for account: ");
        name = scanner.next();

        System.out.print("Enter deposit amount: ");
        amount = scanner.nextDouble();

        try {
            int accountNumber = bank.createAccount(name, amount);
            System.out.println("\nACCOUNT CREATED!");
            System.out.println("Account Number: " + accountNumber + "\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Deposits money into account created
    public static void depositIntoAccount() {
        System.out.println("\n===============");
        System.out.println("   Deposit   ||");
        System.out.println("===============\n");

        try {
            Account userAccount = getAccount();

            if (userAccount != null) {
                System.out.print("Enter deposit amount: ");
                double amount = scanner.nextDouble();

                userAccount.deposit(amount);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Withdraws money from account
    public static void withdrawFromAccount() {
        System.out.println("\n================");
        System.out.println("   Withdraw   ||");
        System.out.println("================\n");

        try {
            Account userAccount = getAccount();

            if (userAccount != null) {
                System.out.print("Enter amount to withdraw: ");
                double amount = scanner.nextDouble();

                userAccount.withdraw(amount);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Checks balance in account
    public static void checkAccountBalance() {
        System.out.println("\n===============");
        System.out.println("   Balance   ||");
        System.out.println("===============\n");

        try {
            Account userAccount = getAccount();

            if (userAccount != null) {
                double balance = userAccount.getBalance();
                System.out.printf("Your balance is: $%.2f\n", balance);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Remove Account from src.main.banking system using account number
    public static void removeAccount() {
        System.out.println("\n======================");
        System.out.println("   Remove Account   ||");
        System.out.println("======================\n");

        try {
            Account userAccount = getAccount();

            System.out.println("\nName: " + userAccount.getAccountHolderName());
            System.out.println("Balance: $" + userAccount.getBalance());
            System.out.println("Are you sure you want to remove account? y/n");
            char userInput = scanner.next().toLowerCase().charAt(0);

            if (userInput == 'y') {
                bank.deleteAccount(userAccount);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Tries to get account based on user input for account number
    public static Account getAccount() {
        System.out.print("Enter Account number: ");
        int userAccNum = scanner.nextInt();

        return bank.getAccount(userAccNum);
    }
}
