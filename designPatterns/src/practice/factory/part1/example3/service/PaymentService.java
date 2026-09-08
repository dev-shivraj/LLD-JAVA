package practice.factory.part1.example3.service;

import practice.factory.part1.example3.factory.PaymentFactory;
import practice.factory.part1.example3.processor.PaymentProcessor;

public class PaymentService {

    public void process(String type, double amount) {
        PaymentProcessor processor = PaymentFactory.create(type);
        processor.pay(amount);
    }
}