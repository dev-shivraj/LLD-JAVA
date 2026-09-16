package practice.strategy.part4.practice2.factory;

import practice.strategy.part4.practice2.strategy.CardPayment;
import practice.strategy.part4.practice2.strategy.PaymentStrategy;
import practice.strategy.part4.practice2.strategy.UpiPayment;
import practice.strategy.part4.practice2.strategy.WalletPayment;

public class PaymentFactory {

    public PaymentStrategy create(String type) {
        return switch (type) {
            case "UPI" -> new UpiPayment();
            case "CARD" -> new CardPayment();
            case "WALLET" -> new WalletPayment();
            default -> throw new IllegalArgumentException("Unsupported payment type: " + type);
        };
    }
}