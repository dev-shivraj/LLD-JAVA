package practice.dip.part1.payment.goodDesign;

public class PaymentService {
    private final PaymentGateway gateway;

    public PaymentService(PaymentGateway gateway) {
        this.gateway = gateway;
    }

    public void processPayment() {
        gateway.pay();
    }
}