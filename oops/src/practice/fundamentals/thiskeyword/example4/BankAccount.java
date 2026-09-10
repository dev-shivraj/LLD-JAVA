package practice.fundamentals.thiskeyword.example4;

public class BankAccount {

    String accountHolder;
    double balance;

    void deposit(double amount) {
        this.balance += amount;
    }

    void showBalance() {
        System.out.println("Balance: " + this.balance);
    }

    void depositAndShowBalance(double amount) {
        this.deposit(amount);
        this.showBalance();
    }
}