package practice.adaptor.part1.payment.external;

public class PayPalGateway {
    public void executePayment(double amount) {
        System.out.println("Paypal payment: " + amount);
    }
}
