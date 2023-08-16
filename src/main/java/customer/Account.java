package src.main.java.customer;

public class Account {
    private int accountNumber;
    private double balance;
    private final String accountHolderName;

    // Constructor
    public Account(String name, double initialDeposit) {
        this.accountHolderName = name;
        this.balance = initialDeposit;
    }

    // Deposit money into account
    public void deposit(double amount) {
        this.balance += amount;
        System.out.printf("%s has successfully deposited $%.2f\n", accountHolderName, amount);
    }

    // Withdraw money from account
    public void withdraw(double amount) {
        if ((this.balance - amount) >= 0) {
            this.balance -= amount;
            System.out.printf("%s has successfully withdrawn $%.2f\n", accountHolderName, amount);
        } else {
            System.out.printf("Cannot withdraw $%.2f because your balance is $%.2f\n",  amount, balance);
        }
    }

    // Check account balance
    public void checkBalance() {
        System.out.printf("%s's current balance is: $%.2f\n", accountHolderName,  balance);
    }
}
