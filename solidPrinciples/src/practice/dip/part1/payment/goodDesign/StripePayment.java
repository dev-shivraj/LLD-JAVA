package practice.dip.part1.payment.goodDesign;

public class StripePayment implements PaymentGateway {
    @Override
    public void pay() {
        System.out.println("Payment processed using Stripe");
    }
}