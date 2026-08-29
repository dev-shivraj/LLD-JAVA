package practice.dip.part2.setterInjection;

public class StripePayment implements PaymentGateway {
    @Override
    public void pay() {
        System.out.println("Payment processed using Stripe");
    }
}