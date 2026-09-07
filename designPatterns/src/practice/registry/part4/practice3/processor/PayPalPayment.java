package practice.registry.part4.practice3.processor;

public class PayPalPayment implements PaymentProcessor {

    @Override
    public void pay(double amount) {
        System.out.println("Processing PAYPAL payment: " + amount);
    }
}