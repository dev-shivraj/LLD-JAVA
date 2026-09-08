package practice.factory.part1.example3.processor;

import practice.factory.part1.example3.gateway.PaymentGateway;

public class CreditCardPayment implements PaymentProcessor {

    private final PaymentGateway gateway;

    public CreditCardPayment(PaymentGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Starting Credit Card payment");
        gateway.process(amount);
    }
}