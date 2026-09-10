package practice.encapsulation.datahiding.example2;

public class Main {

    public static void main(String[] args) {

        BankAccount account = new BankAccount();
        account.deposit(10000);
        System.out.println("Balance: " + account.getBalance());

        // This will not compile because balance is private.
        // account.balance = -5000;
    }
}