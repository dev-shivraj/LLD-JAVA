package practice.registry.part4.example3.processor;

public class UPIPayment implements PaymentProcessor {

    private static int count = 0;

    private final int id;

    public UPIPayment() {
        id = ++count;
    }

    @Override
    public void pay(double amount) {
        System.out.println("UPI payment: " + amount + " | Object ID: " + id);
    }
}