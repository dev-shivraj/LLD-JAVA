package practice.strategy.part2.example3;

import practice.strategy.part2.example3.factory.PaymentStrategyFactory;
import practice.strategy.part2.example3.service.PaymentService;
import practice.strategy.part2.example3.strategy.PaymentStrategy;

public class Client {

    public static void main(String[] args) {

        PaymentStrategy upiStrategy = PaymentStrategyFactory.getStrategy("UPI");
        PaymentService upiPayment = new PaymentService(upiStrategy);
        upiPayment.processPayment(1000);


        PaymentStrategy cardStrategy = PaymentStrategyFactory.getStrategy("CARD");
        PaymentService cardPayment = new PaymentService(cardStrategy);
        cardPayment.processPayment(2000);


        PaymentStrategy payPalStrategy = PaymentStrategyFactory.getStrategy("PAYPAL");
        PaymentService payPalPayment = new PaymentService(payPalStrategy);
        payPalPayment.processPayment(3000);
    }
}