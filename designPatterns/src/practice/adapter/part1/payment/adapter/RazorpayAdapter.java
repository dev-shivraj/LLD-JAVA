package practice.adapter.part1.payment.adapter;

import practice.adapter.part1.payment.external.RazorpayGateway;
import practice.adapter.part1.payment.PaymentProcessor;

public class RazorpayAdapter implements PaymentProcessor {
    private final RazorpayGateway razorpayGateway;

    public RazorpayAdapter(RazorpayGateway razorpayGateway) {
        this.razorpayGateway = razorpayGateway;
    }

    @Override
    public void pay(double amount) {
        razorpayGateway.makePayment(amount);
    }
}
