package practice.encapsulation.accessmodifiers.publicaccess.example1;

public class BankAccount {

    public double balance;

    public void deposit(double amount) {
        balance += amount;
    }
}