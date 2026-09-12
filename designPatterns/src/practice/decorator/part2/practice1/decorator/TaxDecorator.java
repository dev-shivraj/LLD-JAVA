package practice.decorator.part2.practice1.decorator;

import practice.decorator.part2.practice1.component.PaymentProcessor;

public class TaxDecorator extends PaymentProcessorDecorator {

    public TaxDecorator(PaymentProcessor paymentProcessor) {
        super(paymentProcessor);
    }

    @Override
    public void processPayment(double amount) {
        double amountWithTax = amount * 1.18;
        System.out.println("[TAX] 18% tax applied");
        paymentProcessor.processPayment(amountWithTax);
    }
}