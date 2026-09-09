package practice.fundamentals.proceduralvsoop.procedural;

public class BankOperations {
    public static double deposit(double balance, double amount) {
        return balance + amount;
    }

    public static double withdraw(double balance, double amount) {
        if(amount <= balance) {
            return balance - amount;
        }

        System.out.println("Insufficient balance");
        return balance;
    }

    public static void displayBalance(String accountHolder, double balance) {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: " + balance);
    }
}
