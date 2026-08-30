package practice.lsp.part2.invariants.payment.goodDesign;

public class BankAccount {
    protected double balance;

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }

        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= 0 || amount > balance) {
            throw new IllegalArgumentException("Invalid withdrawal");
        }

        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }
}