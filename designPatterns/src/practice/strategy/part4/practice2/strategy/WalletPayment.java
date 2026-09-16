package practice.strategy.part4.practice2.strategy;

public class WalletPayment implements PaymentStrategy {

    @Override
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using WALLET");
    }
}