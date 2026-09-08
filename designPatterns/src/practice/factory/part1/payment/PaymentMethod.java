package practice.factory.part1.payment;

public interface PaymentMethod {
    PaymentResult pay(PaymentRequest request);
}