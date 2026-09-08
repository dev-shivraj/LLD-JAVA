package practice.factory.part2.example2.processor;

import practice.factory.part2.example2.gateway.PaymentGateway;

public class UPIPayment implements PaymentProcessor {
    private final PaymentGateway gateway;

    public UPIPayment(PaymentGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public void pay(double amount) {
        gateway.connect();
        System.out.println("Processing UPI payment: " + amount);
    }
}