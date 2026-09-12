package practice.decorator.part2.practice1.decorator;

import practice.decorator.part2.practice1.component.PaymentProcessor;

public class DiscountDecorator extends PaymentProcessorDecorator {

    public DiscountDecorator(PaymentProcessor paymentProcessor) {
        super(paymentProcessor);
    }

    @Override
    public void processPayment(double amount) {
        double discountedAmount = amount * 0.90;
        System.out.println("[DISCOUNT] 10% discount applied");
        paymentProcessor.processPayment(discountedAmount);
    }
}