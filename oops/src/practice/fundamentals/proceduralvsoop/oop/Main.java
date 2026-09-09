package practice.fundamentals.proceduralvsoop.oop;

public class Main {

    public static void main(String[] args) {

        BankAccount account = new BankAccount();

        account.accountHolder = "Rahul";
        account.balance = 10000;

        account.deposit(5000);
        account.withdraw(2000);

        account.displayBalance();
    }
}