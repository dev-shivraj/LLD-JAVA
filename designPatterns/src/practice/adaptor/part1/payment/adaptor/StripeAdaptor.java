package practice.adaptor.part1.payment.adaptor;

import practice.adaptor.part1.payment.PaymentProcessor;
import practice.adaptor.part1.payment.external.StripeGateway;

public class StripeAdaptor implements PaymentProcessor {
    private final StripeGateway stripeGateway;

    public StripeAdaptor(StripeGateway stripeGateway) {
        this.stripeGateway = stripeGateway;
    }

    @Override
    public void pay(double amount) {
        stripeGateway.charge(amount);
    }
}
