package practice.encapsulation.accessmodifiers.publicaccess.example1;

public class Main {

    public static void main(String[] args) {

        BankAccount account = new BankAccount();

        account.balance = 10000;
        account.deposit(5000);

        System.out.println("Balance: " + account.balance);
    }
}