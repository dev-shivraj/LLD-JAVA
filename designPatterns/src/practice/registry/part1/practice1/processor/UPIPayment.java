package practice.registry.part1.practice1.processor;

public class UPIPayment implements PaymentProcessor{
    @Override
    public void pay(double amount) {
        System.out.println("Processing UPI payment of ₹" + amount);
    }
}
