package practice.factory.part1.example1.processor;

public class PayPalPayment implements PaymentProcessor {

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using PayPal");
    }
}