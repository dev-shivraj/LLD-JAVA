package practice.fundamentals.proceduralvsoop.procedural;

public class Main {
    public static void main(String[] args) {
        String accountHolder = "Rahul";
        double balance = 10_000;

        balance = BankOperations.deposit(balance, 5000);
        balance = BankOperations.withdraw(balance, 2000);

        BankOperations.displayBalance(accountHolder, balance);
    }
}
