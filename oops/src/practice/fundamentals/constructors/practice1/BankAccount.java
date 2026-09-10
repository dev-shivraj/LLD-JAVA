package practice.fundamentals.constructors.practice1;

public class BankAccount {

    String accountNumber;
    String accountHolder;
    double balance;

    BankAccount() {
        accountNumber = "ACC101";
        accountHolder = "Shivraj";
        balance = 50000;
    }

    void displayInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: " + balance);
    }
}