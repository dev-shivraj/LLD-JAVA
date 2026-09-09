package practice.fundamentals.oop.example1;

public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        account.accountHolder = "Shivraj";
        account.balance = 10000;
        account.displayBalance();


        account.deposit(5000);
        account.displayBalance();

        account.withdraw(2000);
        account.displayBalance();
    }
}
