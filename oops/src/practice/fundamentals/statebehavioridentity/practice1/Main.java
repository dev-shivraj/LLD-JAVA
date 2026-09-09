package practice.fundamentals.statebehavioridentity.practice1;

public class Main {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount();
        account1.accountNumber = "ACC101";
        account1.accountHolder = "Rahul";
        account1.balance = 10000;


        BankAccount account2 = new BankAccount();
        account2.accountNumber = "ACC102";
        account2.accountHolder = "Rahul";
        account2.balance = 10000;


        System.out.println("Before deposit:");
        account1.displayInfo();
        System.out.println();
        account2.displayInfo();
        account1.deposit(5000);
        System.out.println();


        System.out.println("After account1 deposits 5000:");
        System.out.println("Account 1 balance: " + account1.balance);
        System.out.println("Account 2 balance: " + account2.balance);
        System.out.println();


        System.out.println("Are account1 and account2 the same object?");
        System.out.println(account1 == account2);
    }
}
