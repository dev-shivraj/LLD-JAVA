package practice.fundamentals.instancevariables.example4;

public class BankAccount {

    String accountHolder;
    double balance;

    void deposit(double amount) {
        balance = balance + amount;
    }

    void displayBalance() {
        System.out.println(accountHolder + "'s balance: " + balance);
    }
}