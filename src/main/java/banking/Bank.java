package src.main.java.banking;

import java.util.ArrayList;

public class Bank {
    private final ArrayList<Account> listOfAccounts;
    private int accountNumber;

    // Constructor
    public Bank() {
        this.listOfAccounts = new ArrayList<Account>();
        this.accountNumber = 0;
    }

    // Getters - Get Account based on account number
    public Account getAccount(int accountNum) {
        for (Account account : this.listOfAccounts) {
            if (account.getAccountNumber() == accountNum)
                return account;
        }
        System.out.println("Could not find account.");
        return null;
    }

    // Create account using name and initial deposit
    // Account number is assigned and returned
    public int createAccount(String name, double initialDeposit) {
        this.listOfAccounts.add(new Account(name, initialDeposit, ++this.accountNumber));
        return this.accountNumber;
    }

    // Removes account based on account number
    public void deleteAccount(Account accountToBeDeleted) {
        if (listOfAccounts.contains(accountToBeDeleted)) {
            this.listOfAccounts.remove(accountToBeDeleted);
            System.out.println("Account has been removed");
        } else
            System.out.println("Account does not exist");
    }
}
