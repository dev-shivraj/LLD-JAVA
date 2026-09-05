package practice.adaptor.part1.payment.adaptor;

import practice.adaptor.part1.payment.PaymentProcessor;
import practice.adaptor.part1.payment.external.PayPalGateway;

public class PaypalAdaptor implements PaymentProcessor {
    private final PayPalGateway payPalGateway;

    public PaypalAdaptor(PayPalGateway payPalGateway) {
        this.payPalGateway = payPalGateway;
    }

    @Override
    public void pay(double amount) {
        payPalGateway.executePayment(amount);
    }
}
