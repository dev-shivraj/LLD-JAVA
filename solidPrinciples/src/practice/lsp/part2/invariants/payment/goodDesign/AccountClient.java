package practice.lsp.part2.invariants.payment.goodDesign;

public class AccountClient {
    public static void main(String[] args) {
        BankAccount account = new SavingsAccount();
        account.deposit(1000);
        account.withdraw(500);
        System.out.println("Balance: " + account.getBalance());
    }
}