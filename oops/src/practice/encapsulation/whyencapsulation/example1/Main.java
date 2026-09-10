package practice.encapsulation.whyencapsulation.example1;

public class Main {

    public static void main(String[] args) {

        BankAccount account = new BankAccount();

        account.accountHolder = "Shivraj";
        account.balance = 10000;

        System.out.println("Account Holder: " + account.accountHolder);
        System.out.println("Balance: " + account.balance);

        account.balance = -50000;
        System.out.println("Balance after invalid modification: " + account.balance);

        account.balance = 999999999;
        System.out.println("Balance after another modification: " + account.balance);
    }
}