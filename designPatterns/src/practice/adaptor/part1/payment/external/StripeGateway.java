package practice.adaptor.part1.payment.external;

public class StripeGateway {
    public void charge(double amount) {
        System.out.println("Stripe Payment: " + amount);
    }
}
