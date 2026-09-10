package practice.encapsulation.accessmodifiers.protectedaccess.example1;

public class Main {

    public static void main(String[] args) {

        SavingsAccount account = new SavingsAccount();

        account.deposit(10000);
        account.showBalance();
    }
}