package practice.lsp.part2.invariants.payment.badDesign;

public class BankAccount {
    protected double balance;

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }

        balance += amount;
    }

    public double getBalance() {
        return balance;
    }
}