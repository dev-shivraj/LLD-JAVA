package practice.encapsulation.accessmodifiers.protectedaccess.example2.savings;

import practice.encapsulation.accessmodifiers.protectedaccess.example2.bank.BankAccount;

public class SavingsAccount extends BankAccount {

    public void deposit(double amount) {
        balance += amount;
    }

    public void showBalance() {
        displayBalance();
    }
}