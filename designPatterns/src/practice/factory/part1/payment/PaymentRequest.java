package practice.factory.part1.payment;

import practice.factory.part1.payment.enums.PaymentType;

public record PaymentRequest(PaymentType paymentType, double amount) {

    public PaymentRequest {
        if (paymentType == null) {
            throw new IllegalArgumentException("Payment type cannot be null");
        }

        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero");
        }
    }
}