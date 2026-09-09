package practice.fundamentals.statebehavioridentity.practice1;

public class BankAccount {
    String accountNumber;
    String accountHolder;
    double balance;


    void deposit(double amount) {
        balance += amount;
    }

    void withdraw(double amount) {
        if(amount <= balance)
            balance -= amount;

        System.out.println("Insufficient Balance");
    }

    void displayInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: " + balance);
    }
}
