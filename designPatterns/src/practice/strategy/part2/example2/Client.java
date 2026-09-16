package practice.strategy.part2.example2;

import practice.strategy.part2.example2.service.PaymentService;
import practice.strategy.part2.example2.strategy.CardPaymentStrategy;
import practice.strategy.part2.example2.strategy.UpiPaymentStrategy;

public class Client {

    public static void main(String[] args) {

        PaymentService paymentService = new PaymentService();
        paymentService.setPaymentStrategy(new UpiPaymentStrategy());
        paymentService.processPayment(1000);


        paymentService.setPaymentStrategy(new CardPaymentStrategy());
        paymentService.processPayment(2000);
    }
}