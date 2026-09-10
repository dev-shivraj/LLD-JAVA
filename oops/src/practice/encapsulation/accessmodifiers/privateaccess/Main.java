package practice.encapsulation.accessmodifiers.privateaccess;

public class Main {

    public static void main(String[] args) {

        BankAccount account = new BankAccount();

        account.deposit(10000);
        account.displayBalanceInsideClass();
        System.out.println("Balance: " + account.getBalance());

        // Not allowed:
        // account.balance = 50000;
    }
}