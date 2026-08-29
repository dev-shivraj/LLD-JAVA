package practice.dip.part2.constructorInjection;

public class PaymentService {
    private final PaymentGateway paymentGateway;

    public PaymentService(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public void processPayment() {
        paymentGateway.pay();
    }
}