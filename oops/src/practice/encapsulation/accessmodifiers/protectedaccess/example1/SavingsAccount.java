package practice.encapsulation.accessmodifiers.protectedaccess.example1;

public class SavingsAccount extends BankAccount {

    public void deposit(double amount) {
        balance += amount;
    }

    public void showBalance() {
        displayBalance();
    }
}