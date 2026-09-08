package practice.factory.part1.payment;

import java.util.UUID;

public class UpiPaymentMethod implements PaymentMethod {
    @Override
    public PaymentResult pay(PaymentRequest request) {
        String transactionId = UUID.randomUUID().toString();

        return new PaymentResult(true, transactionId, "UPI payment successful");
    }
}