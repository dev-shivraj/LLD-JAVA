package practice.dip.part4.integrated.badDesign;

public class StripePayment {
    public void pay(double amount) {
        System.out.println("Payment processed using Stripe: " + amount);
    }
}