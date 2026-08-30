package practice.lsp.part2.invariants.payment.badDesign;

public class AccountClient {
    public static void main(String[] args) {
        BankAccount account = new SpecialAccount();
        account.deposit(1000);
        SpecialAccount specialAccount = (SpecialAccount) account;

        specialAccount.withdraw(5000);
        System.out.println("Balance: " + specialAccount.getBalance());
    }
}