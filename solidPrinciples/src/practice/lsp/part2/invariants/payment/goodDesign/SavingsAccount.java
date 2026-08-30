package practice.lsp.part2.invariants.payment.goodDesign;

public class SavingsAccount extends BankAccount {
    @Override
    public void withdraw(double amount) {
        if (amount <= 0 || amount > balance) {
            throw new IllegalArgumentException("Invalid withdrawal");
        }

        balance -= amount;
        System.out.println("Withdrawal successful");
    }
}