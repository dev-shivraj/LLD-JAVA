package practice.registry.part1.miniproject.processor;

public class WalletProcessor implements PaymentProcessor {

    @Override
    public void pay(double amount) {
        System.out.println("Processing Wallet payment: ₹" + amount);
    }
}