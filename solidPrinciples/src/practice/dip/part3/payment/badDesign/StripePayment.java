package practice.dip.part3.payment.badDesign;

public class StripePayment {

    public void pay(double amount) {

        System.out.println(
                "Payment processed using Stripe: "
                        + amount
        );
    }
}