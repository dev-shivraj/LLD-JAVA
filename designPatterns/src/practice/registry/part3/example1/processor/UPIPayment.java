package practice.registry.part3.example1.processor;

public class UPIPayment implements PaymentProcessor {

    public UPIPayment() {
        System.out.println("Creating UPIPayment");
    }

    @Override
    public void pay(double amount) {
        System.out.println("Processing UPI payment: " + amount);
    }
}