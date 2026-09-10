package practice.encapsulation.accessmodifiers.protectedaccess.example2.bank;

public class BankAccount {

    protected double balance;

    protected void displayBalance() {
        System.out.println("Balance: " + balance);
    }
}