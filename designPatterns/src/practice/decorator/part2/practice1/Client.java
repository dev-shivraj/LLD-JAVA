package practice.decorator.part2.practice1;

import practice.decorator.part2.practice1.component.BasicPaymentProcessor;
import practice.decorator.part2.practice1.component.PaymentProcessor;
import practice.decorator.part2.practice1.decorator.DiscountDecorator;
import practice.decorator.part2.practice1.decorator.LoggingDecorator;
import practice.decorator.part2.practice1.decorator.TaxDecorator;

public class Client {

    public static void main(String[] args) {

        PaymentProcessor processor = new BasicPaymentProcessor();

        processor = new DiscountDecorator(processor);
        processor = new TaxDecorator(processor);
        processor = new LoggingDecorator(processor);

        processor.processPayment(1000);
    }
}