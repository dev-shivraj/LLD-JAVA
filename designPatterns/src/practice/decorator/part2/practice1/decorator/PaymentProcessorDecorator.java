package practice.decorator.part2.practice1.decorator;

import practice.decorator.part2.practice1.component.PaymentProcessor;

public abstract class PaymentProcessorDecorator implements PaymentProcessor {

    protected PaymentProcessor paymentProcessor;

    protected PaymentProcessorDecorator(PaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }

    @Override
    public void processPayment(double amount) {
        paymentProcessor.processPayment(amount);
    }
}