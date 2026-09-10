package practice.encapsulation.encapsulation.practice1;

public class Main {

    public static void main(String[] args) {

        BankAccount account = new BankAccount("ACC101", "Shivraj", 50000);

        System.out.println("Initial account details:");
        account.displayInfo();
        System.out.println();

        System.out.println("Depositing 5000:");
        account.deposit(5000);
        account.displayInfo();
        System.out.println();

        System.out.println("Withdrawing 10000:");
        account.withdraw(10000);
        account.displayInfo();
        System.out.println();

        System.out.println("Trying invalid deposit:");
        account.deposit(-500);
        System.out.println();

        System.out.println("Trying invalid withdrawal:");
        account.withdraw(-1000);
        System.out.println();

        System.out.println("Trying withdrawal greater than balance:");
        account.withdraw(100000);
        System.out.println();

        System.out.println("Final account details:");
        account.displayInfo();
    }
}