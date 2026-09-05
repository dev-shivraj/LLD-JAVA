package practice.adaptor.part1.payment.adaptor;

import practice.adaptor.part1.payment.external.RazorpayGateway;
import practice.adaptor.part1.payment.PaymentProcessor;

public class RazorpayAdaptor implements PaymentProcessor {
    private final RazorpayGateway razorpayGateway;

    public RazorpayAdaptor(RazorpayGateway razorpayGateway) {
        this.razorpayGateway = razorpayGateway;
    }

    @Override
    public void pay(double amount) {
        razorpayGateway.makePayment(amount);
    }
}
