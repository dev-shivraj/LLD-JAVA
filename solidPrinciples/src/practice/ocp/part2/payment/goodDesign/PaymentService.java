package practice.ocp.part2.payment.goodDesign;

public class PaymentService {

    public void processPayment(Payment payment, double amount) {
        payment.processPayment(amount);
    }
}