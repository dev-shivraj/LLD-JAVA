package practice.adapter.part1.payment.adapter;

import practice.adapter.part1.payment.PaymentProcessor;
import practice.adapter.part1.payment.external.PayPalGateway;

public class PaypalAdapter implements PaymentProcessor {
    private final PayPalGateway payPalGateway;

    public PaypalAdapter(PayPalGateway payPalGateway) {
        this.payPalGateway = payPalGateway;
    }

    @Override
    public void pay(double amount) {
        payPalGateway.executePayment(amount);
    }
}
