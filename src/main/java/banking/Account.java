package src.main.java.banking;

public class Account
{
    private final String accountHolderName;
    private double balance;
    private final int accountNumber;

    // Constructor
    protected Account(String name, double initialDeposit, int accountNumber)
    {
        this.accountHolderName = name;
        this.balance = initialDeposit;
        this.accountNumber = accountNumber;
    }

    // Getters
    protected int getAccountNumber() { return this.accountNumber; }
    public String getAccountHolderName() { return this.accountHolderName; }
    public double getBalance() { return this.balance; }

    // Deposit money into account
    public void deposit(double amount)
    {
        this.balance += amount;
        System.out.printf("%s has successfully deposited $%.2f\n", accountHolderName, amount);
    }

    // Withdraw money from account
    public void withdraw(double amount)
    {
        if ((this.balance - amount) >= 0)
        {
            this.balance -= amount;
            System.out.printf("%s has successfully withdrawn $%.2f\n", accountHolderName, amount);
        }
        else
            System.out.printf("Cannot withdraw $%.2f because your balance is $%.2f\n",  amount, balance);
    }

}
