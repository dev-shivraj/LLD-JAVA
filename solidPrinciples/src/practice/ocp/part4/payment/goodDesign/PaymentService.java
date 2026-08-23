package practice.ocp.part4.payment.goodDesign;

public class PaymentService {

    public void processPayment(Payment payment, double amount) {
        payment.process(amount);
    }
}