package practice.dip.part2.setterInjection;

public class PaymentService {
    private PaymentGateway paymentGateway;

    public void setPaymentGateway(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public void processPayment() {
        paymentGateway.pay();
    }
}