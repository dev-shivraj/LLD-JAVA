package practice.strategy.part1.example1;

import practice.strategy.part1.example1.service.PaymentService;
import practice.strategy.part1.example1.strategy.CreditCardPaymentStrategy;
import practice.strategy.part1.example1.strategy.PayPalPaymentStrategy;
import practice.strategy.part1.example1.strategy.PaymentStrategy;
import practice.strategy.part1.example1.strategy.UpiPaymentStrategy;

public class Client {

    public static void main(String[] args) {

        PaymentStrategy creditCardStrategy = new CreditCardPaymentStrategy();
        PaymentService creditCardPayment = new PaymentService(creditCardStrategy);
        creditCardPayment.processPayment(1000);


        PaymentStrategy upiStrategy = new UpiPaymentStrategy();
        PaymentService upiPayment = new PaymentService(upiStrategy);
        upiPayment.processPayment(500);


        PaymentStrategy payPalStrategy = new PayPalPaymentStrategy();
        PaymentService payPalPayment = new PaymentService(payPalStrategy);
        payPalPayment.processPayment(1500);
    }
}