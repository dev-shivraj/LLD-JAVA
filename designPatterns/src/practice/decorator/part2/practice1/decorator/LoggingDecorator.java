package practice.decorator.part2.practice1.decorator;

import practice.decorator.part2.practice1.component.PaymentProcessor;

public class LoggingDecorator extends PaymentProcessorDecorator {

    public LoggingDecorator(PaymentProcessor paymentProcessor) {
        super(paymentProcessor);
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("[LOG] Payment started");
        paymentProcessor.processPayment(amount);
        System.out.println("[LOG] Payment completed");
    }
}