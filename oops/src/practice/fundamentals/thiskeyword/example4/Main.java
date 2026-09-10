package practice.fundamentals.thiskeyword.example4;

public class Main {

    public static void main(String[] args) {

        BankAccount account = new BankAccount();

        account.accountHolder = "Shivraj";
        account.balance = 10000;

        account.depositAndShowBalance(5000);
    }
}