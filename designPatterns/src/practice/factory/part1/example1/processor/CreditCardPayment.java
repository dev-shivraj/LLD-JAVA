package practice.factory.part1.example1.processor;

public class CreditCardPayment implements PaymentProcessor {

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Credit Card");
    }
}