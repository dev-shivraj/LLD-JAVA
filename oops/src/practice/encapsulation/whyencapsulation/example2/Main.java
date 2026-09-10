package practice.encapsulation.whyencapsulation.example2;

public class Main {

    public static void main(String[] args) {

        BankAccount account = new BankAccount();

        account.deposit(10000);
        System.out.println("Balance: " + account.getBalance());

        account.withdraw(3000);
        System.out.println("Balance: " + account.getBalance());

        account.withdraw(10000);
        System.out.println("Balance: " + account.getBalance());

        account.deposit(-500);
        System.out.println("Final Balance: " + account.getBalance());
    }
}