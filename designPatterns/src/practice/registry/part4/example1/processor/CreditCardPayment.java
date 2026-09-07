package practice.registry.part4.example1.processor;

public class CreditCardPayment implements PaymentProcessor {

    public CreditCardPayment() {
        System.out.println("Creating CreditCardPayment");
    }

    @Override
    public void pay(double amount) {
        System.out.println("Processing CREDIT CARD payment: " + amount);
    }
}