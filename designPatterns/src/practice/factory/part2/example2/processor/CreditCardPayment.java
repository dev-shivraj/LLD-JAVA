package practice.factory.part2.example2.processor;

import practice.factory.part2.example2.gateway.PaymentGateway;

public class CreditCardPayment implements PaymentProcessor {
    private final PaymentGateway gateway;

    public CreditCardPayment(PaymentGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public void pay(double amount) {
        gateway.connect();
        System.out.println("Processing Credit Card payment: " + amount);
    }
}