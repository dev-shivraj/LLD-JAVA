package practice.factory.part1.example2.factory;

import practice.factory.part1.example2.processor.CreditCardPayment;
import practice.factory.part1.example2.processor.PayPalPayment;
import practice.factory.part1.example2.processor.PaymentProcessor;
import practice.factory.part1.example2.processor.UPIPayment;

public class PaymentFactory {

    public static PaymentProcessor create(String type) {
        if (type == null || type.isBlank()) {
            throw new IllegalArgumentException("Payment type cannot be null or blank");
        }

        return switch (type.toLowerCase()) {
            case "credit_card" -> new CreditCardPayment();
            case "upi" -> new UPIPayment();
            case "paypal" -> new PayPalPayment();
            default -> throw new IllegalArgumentException("Unknown payment type: " + type);
        };
    }
}