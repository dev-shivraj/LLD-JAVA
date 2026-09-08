package practice.factory.part1.example1;

import practice.factory.part1.example1.factory.PaymentFactory;
import practice.factory.part1.example1.processor.PaymentProcessor;

public class Main {

    public static void main(String[] args) {
        PaymentProcessor payment = PaymentFactory.create("upi");
        payment.pay(1000);

        PaymentProcessor creditCard = PaymentFactory.create("credit_card");
        creditCard.pay(2500);

        PaymentProcessor paypal = PaymentFactory.create("paypal");
        paypal.pay(500);
    }
}