package practice.factory.part1.simplefactory;

public class PaymentService {
    public void processPayment(String paymentType, double amount) {
        Payment payment = PaymentFactory.createPayment(paymentType);
        payment.pay(amount);
    }
}
