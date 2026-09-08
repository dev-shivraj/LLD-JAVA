package practice.factory.part1.example2.processor;

public class PayPalPayment implements PaymentProcessor {

    @Override
    public void pay(double amount) {
        System.out.println("Processing PayPal payment: " + amount);
    }
}