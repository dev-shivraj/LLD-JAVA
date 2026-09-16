package practice.strategy.part4.practice1.strategy;

public class WalletPayment implements PaymentStrategy {

    @Override
    public void pay(double amount) {
        System.out.println("Processing WALLET payment: ₹" + amount);
    }
}