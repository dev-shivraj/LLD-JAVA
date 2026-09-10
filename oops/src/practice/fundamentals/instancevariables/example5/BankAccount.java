package practice.fundamentals.instancevariables.example5;

public class BankAccount {

    String accountHolder;
    double balance;

    void deposit(double amount) {
        balance += amount;
    }
}