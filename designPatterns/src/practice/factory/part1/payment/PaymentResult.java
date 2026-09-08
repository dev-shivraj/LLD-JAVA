package practice.factory.part1.payment;

public record PaymentResult(boolean success, String transactionId, String message) {
}