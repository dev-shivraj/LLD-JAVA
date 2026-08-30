package practice.lsp.part2.invariants.payment.badDesign;

public class SpecialAccount extends BankAccount {
    public void withdraw(double amount) {
        balance -= amount;
        System.out.println("Amount withdrawn");
    }
}