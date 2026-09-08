package practice.factory.part1.example2.service;

import practice.factory.part1.example2.factory.PaymentFactory;
import practice.factory.part1.example2.processor.PaymentProcessor;

public class PaymentService {
    public void processPayment(String type, double amount) {
        PaymentProcessor processor = PaymentFactory.create(type);
        processor.pay(amount);
    }
}