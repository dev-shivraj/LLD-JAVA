package practice.registry.part3.example1.processor;

public class PayPalPayment implements PaymentProcessor {

    public PayPalPayment() {
        System.out.println("Creating PayPalPayment");
    }

    @Override
    public void pay(double amount) {
        System.out.println("Processing PAYPAL payment: " + amount);
    }
}