package practice.dip.part3.payment.goodDesign;

public class StripePayment
        implements PaymentGateway {

    @Override
    public void pay(double amount) {

        System.out.println(
                "Payment processed using Stripe: "
                        + amount
        );
    }
}