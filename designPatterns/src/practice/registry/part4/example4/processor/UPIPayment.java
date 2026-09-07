package practice.registry.part4.example4.processor;

public class UPIPayment implements PaymentProcessor {

    @Override
    public void pay(double amount) {
        System.out.println("Processing UPI payment: " + amount);
    }
}