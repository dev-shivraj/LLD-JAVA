package practice.ocp.part2.payment.badDesign;

public class PaymentService {

    public void processPayment(String type, double amount) {
        if (type.equals("UPI")) {
            System.out.println("Processing UPI payment: " + amount);
        } else if (type.equals("CREDIT_CARD")) {
            System.out.println("Processing Credit Card payment: " + amount);
        } else if (type.equals("PAYPAL")) {
            System.out.println("Processing PayPal payment: " + amount);
        }
    }
}