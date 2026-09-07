package practice.registry.part4.example4.processor;

public class PayPalPayment implements PaymentProcessor {

    @Override
    public void pay(double amount) {
        System.out.println("Processing PAYPAL payment: " + amount);
    }
}