package practice.factory.part2.practice1.processor;

public class CreditCardPayment implements PaymentProcessor {
    @Override
    public void pay(double amount) {
        System.out.println("Processing Credit Card payment: " + amount);
    }
}