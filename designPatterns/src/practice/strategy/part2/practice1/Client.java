package practice.strategy.part2.practice1;

import practice.strategy.part2.practice1.service.PaymentService;
import practice.strategy.part2.practice1.strategy.CardPaymentStrategy;
import practice.strategy.part2.practice1.strategy.PayPalPaymentStrategy;
import practice.strategy.part2.practice1.strategy.UpiPaymentStrategy;

public class Client {

    public static void main(String[] args) {

        PaymentService service = new PaymentService();
        service.setPaymentStrategy(new UpiPaymentStrategy());
        service.processPayment(1000);


        service.setPaymentStrategy(new CardPaymentStrategy());
        service.processPayment(2000);


        service.setPaymentStrategy(new PayPalPaymentStrategy());
        service.processPayment(3000);
    }
}