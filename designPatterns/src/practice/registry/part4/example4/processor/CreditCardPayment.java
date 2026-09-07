package practice.registry.part4.example4.processor;

public class CreditCardPayment implements PaymentProcessor {

    @Override
    public void pay(double amount) {
        System.out.println("Processing CREDIT CARD payment: " + amount);
    }
}