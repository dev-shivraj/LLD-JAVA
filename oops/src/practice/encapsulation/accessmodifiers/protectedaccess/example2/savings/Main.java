package practice.encapsulation.accessmodifiers.protectedaccess.example2.savings;

public class Main {

    public static void main(String[] args) {

        SavingsAccount account = new SavingsAccount();

        account.deposit(10000);
        account.showBalance();
    }
}