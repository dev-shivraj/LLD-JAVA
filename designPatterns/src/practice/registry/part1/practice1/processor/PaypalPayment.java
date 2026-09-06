package practice.registry.part1.practice1.processor;

public class PaypalPayment implements PaymentProcessor{
    @Override
    public void pay(double amount) {
        System.out.println("Processing PayPal payment of ₹" + amount);
    }
}
