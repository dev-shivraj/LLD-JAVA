package practice.dip.part2.methodInjection;

public class PaymentService {
    public void processPayment(PaymentGateway paymentGateway) {
        paymentGateway.pay();
    }
}