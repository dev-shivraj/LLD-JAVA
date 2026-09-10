package practice.encapsulation.accessmodifiers.protectedaccess.example1;

public class BankAccount {

    protected double balance;

    protected void displayBalance() {
        System.out.println("Balance: " + balance);
    }
}