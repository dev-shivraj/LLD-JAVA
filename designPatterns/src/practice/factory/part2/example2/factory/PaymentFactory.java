package practice.factory.part2.example2.factory;

import practice.factory.part2.example2.gateway.CreditCardGateway;
import practice.factory.part2.example2.gateway.UpiGateway;
import practice.factory.part2.example2.processor.CreditCardPayment;
import practice.factory.part2.example2.processor.PaymentProcessor;
import practice.factory.part2.example2.processor.UPIPayment;

public class PaymentFactory {
    public static PaymentProcessor create(String type) {
        if (type == null || type.isBlank()) {
            throw new IllegalArgumentException("Payment type cannot be null or blank");
        }

        return switch (type.toLowerCase()) {
            case "upi" -> new UPIPayment(new UpiGateway());
            case "credit_card" -> new CreditCardPayment(new CreditCardGateway());
            default -> throw new IllegalArgumentException("Unknown payment type: " + type);
        };
    }
}