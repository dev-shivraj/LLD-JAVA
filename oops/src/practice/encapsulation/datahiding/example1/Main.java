package practice.encapsulation.datahiding.example1;

public class Main {

    public static void main(String[] args) {

        BankAccount account = new BankAccount();

        account.balance = 10000;
        System.out.println("Balance: " + account.balance);

        account.balance = -5000;
        System.out.println("Balance after invalid modification: " + account.balance);
    }
}