package src.main.java;

import src.main.java.customer.Account;

public class Main {


    public static void main(String[] args) {

        Account a = new Account("Bryan", 50);


        a.checkBalance();

        a.deposit(100);

        a.withdraw(100);
        a.checkBalance();

        a.withdraw(50);
        a.withdraw(150);
    }
}
