package practice.factory.part1.example3.factory;

import practice.factory.part1.example3.gateway.CreditCardGateway;
import practice.factory.part1.example3.gateway.PaymentGateway;
import practice.factory.part1.example3.gateway.UpiGateway;
import practice.factory.part1.example3.processor.CreditCardPayment;
import practice.factory.part1.example3.processor.PaymentProcessor;
import practice.factory.part1.example3.processor.UPIPayment;

public class PaymentFactory {

    public static PaymentProcessor create(String type) {

        if (type == null || type.isBlank()) {
            throw new IllegalArgumentException("Payment type cannot be null or blank");
        }

        return switch (type.toLowerCase()) {
            case "upi" -> {
                PaymentGateway gateway = new UpiGateway();
                yield new UPIPayment(gateway);
            }
            case "credit_card" -> {
                PaymentGateway gateway = new CreditCardGateway();
                yield new CreditCardPayment(gateway);
            }
            default -> throw new IllegalArgumentException("Unknown payment type: " + type);
        };
    }
}