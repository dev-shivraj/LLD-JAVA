package practice.registry.part1.miniproject.processor;

public class UpiProcessor implements PaymentProcessor {

    @Override
    public void pay(double amount) {
        System.out.println("Processing UPI payment: ₹" + amount);
    }
}