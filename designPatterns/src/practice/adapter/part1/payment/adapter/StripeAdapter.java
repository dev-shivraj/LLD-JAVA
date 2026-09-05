package practice.adapter.part1.payment.adapter;

import practice.adapter.part1.payment.PaymentProcessor;
import practice.adapter.part1.payment.external.StripeGateway;

public class StripeAdapter implements PaymentProcessor {
    private final StripeGateway stripeGateway;

    public StripeAdapter(StripeGateway stripeGateway) {
        this.stripeGateway = stripeGateway;
    }

    @Override
    public void pay(double amount) {
        stripeGateway.charge(amount);
    }
}
