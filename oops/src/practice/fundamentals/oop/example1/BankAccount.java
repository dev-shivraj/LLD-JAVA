package practice.fundamentals.oop.example1;

public class BankAccount {
    String accountHolder;
    double balance;

    void deposit(double amount) {
        balance += amount;
    }

    void withdraw(double amount) {
        balance -= amount;
    }

    void displayBalance() {
        System.out.println("Balance: " + balance);
    }
}
