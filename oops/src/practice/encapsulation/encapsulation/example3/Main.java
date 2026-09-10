package practice.encapsulation.encapsulation.example3;

public class Main {

    public static void main(String[] args) {

        BankAccount account = new BankAccount();

        account.setAccountHolder("Shivraj");
        account.deposit(50000);
        account.displayInfo();
        System.out.println();

        account.deposit(5000);
        account.withdraw(10000);
        account.displayInfo();
        System.out.println();

        account.deposit(-500);
        account.withdraw(100000);
    }
}