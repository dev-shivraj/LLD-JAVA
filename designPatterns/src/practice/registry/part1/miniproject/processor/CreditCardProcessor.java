package practice.registry.part1.miniproject.processor;

public class CreditCardProcessor implements PaymentProcessor {

    @Override
    public void pay(double amount) {
        System.out.println("Processing Credit Card payment: ₹" + amount);
    }
}