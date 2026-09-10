package practice.encapsulation.accessmodifiers.defaultaccess.example2;

import practice.encapsulation.accessmodifiers.defaultaccess.example1.BankAccount;

public class Main {

    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        // Not allowed because balance has default access.
        // account.balance = 10000;

        // Not allowed because deposit() has default access.
        // account.deposit(5000);
    }
}