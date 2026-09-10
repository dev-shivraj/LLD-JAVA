package practice.fundamentals.instancevariables.example5;

public class Main {

    public static void main(String[] args) {

        BankAccount account1 = new BankAccount();
        BankAccount account2 = new BankAccount();

        account1.accountHolder = "Shivraj";
        account1.balance = 10000;

        account2.accountHolder = "Rahul";
        account2.balance = 20000;

        account1.deposit(5000);

        System.out.println(account1.accountHolder + ": " + account1.balance);
        System.out.println(account2.accountHolder + ": " + account2.balance);
    }
}