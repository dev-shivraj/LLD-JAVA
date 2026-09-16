package practice.strategy.part2.example1;

import practice.strategy.part2.example1.service.PaymentService;
import practice.strategy.part2.example1.strategy.CardPaymentStrategy;
import practice.strategy.part2.example1.strategy.PaymentStrategy;
import practice.strategy.part2.example1.strategy.UpiPaymentStrategy;

public class Client {

    public static void main(String[] args) {

        PaymentStrategy upiStrategy = new UpiPaymentStrategy();
        PaymentService upiPayment = new PaymentService(upiStrategy);
        upiPayment.processPayment(1000);


        PaymentStrategy cardStrategy = new CardPaymentStrategy();
        PaymentService cardPayment = new PaymentService(cardStrategy);
        cardPayment.processPayment(2000);
    }
}