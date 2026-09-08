package practice.factory.part1.example3.processor;

import practice.factory.part1.example3.gateway.PaymentGateway;

public class UPIPayment implements PaymentProcessor {

    private final PaymentGateway gateway;

    public UPIPayment(PaymentGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Starting UPI payment");
        gateway.process(amount);
    }
}