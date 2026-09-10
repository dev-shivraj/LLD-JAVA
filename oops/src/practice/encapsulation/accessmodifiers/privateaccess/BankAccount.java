package practice.encapsulation.accessmodifiers.privateaccess;

public class BankAccount {

    private double balance;

    public void deposit(double amount) {
        balance += amount;
    }

    public double getBalance() {
        return balance;
    }

    public void displayBalanceInsideClass() {
        System.out.println("Balance: " + balance);
    }
}