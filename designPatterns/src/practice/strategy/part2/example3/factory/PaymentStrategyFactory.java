package practice.strategy.part2.example3.factory;

import practice.strategy.part2.example3.strategy.CardPaymentStrategy;
import practice.strategy.part2.example3.strategy.PayPalPaymentStrategy;
import practice.strategy.part2.example3.strategy.PaymentStrategy;
import practice.strategy.part2.example3.strategy.UpiPaymentStrategy;

public class PaymentStrategyFactory {

    public static PaymentStrategy getStrategy(String paymentType) {
        return switch (paymentType.toUpperCase()) {
            case "UPI" -> new UpiPaymentStrategy();
            case "CARD" -> new CardPaymentStrategy();
            case "PAYPAL" -> new PayPalPaymentStrategy();
            default -> throw new IllegalArgumentException("Unsupported payment type: " + paymentType);
        };
    }
}