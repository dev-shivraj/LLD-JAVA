package practice.encapsulation.whyencapsulation.practice1;

public class Main {

    public static void main(String[] args) {

        BankAccount account = new BankAccount(10000);
        System.out.println("Initial balance: " + account.getBalance());

        account.deposit(5000);
        System.out.println("After deposit: " + account.getBalance());

        account.withdraw(3000);
        System.out.println("After withdrawal: " + account.getBalance());

        account.withdraw(20000);
        account.deposit(-500);
        System.out.println("Final balance: " + account.getBalance());
    }
}