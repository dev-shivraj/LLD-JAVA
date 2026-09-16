package practice.strategy.part2.example4;

import practice.strategy.part2.example4.registry.PaymentStrategyRegistry;
import practice.strategy.part2.example4.service.PaymentService;
import practice.strategy.part2.example4.strategy.CardPaymentStrategy;
import practice.strategy.part2.example4.strategy.PayPalPaymentStrategy;
import practice.strategy.part2.example4.strategy.PaymentStrategy;
import practice.strategy.part2.example4.strategy.UpiPaymentStrategy;

public class Client {

    public static void main(String[] args) {

        PaymentStrategyRegistry registry = new PaymentStrategyRegistry();
        registry.register("UPI", new UpiPaymentStrategy());
        registry.register("CARD", new CardPaymentStrategy());
        registry.register("PAYPAL", new PayPalPaymentStrategy());


        PaymentStrategy strategy = registry.getStrategy("UPI");
        PaymentService paymentService = new PaymentService(strategy);
        paymentService.processPayment(1000);


        strategy = registry.getStrategy("CARD");
        paymentService = new PaymentService(strategy);
        paymentService.processPayment(2000);
    }
}