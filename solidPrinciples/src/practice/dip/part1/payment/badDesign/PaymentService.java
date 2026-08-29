package practice.dip.part1.payment.badDesign;

public class PaymentService {
    private final StripePayment payment = new StripePayment();

    public void processPayment() {
        payment.pay();
    }
}