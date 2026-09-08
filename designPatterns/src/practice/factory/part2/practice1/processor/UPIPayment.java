package practice.factory.part2.practice1.processor;

public class UPIPayment implements PaymentProcessor {
    @Override
    public void pay(double amount) {
        System.out.println("Processing UPI payment: " + amount);
    }
}