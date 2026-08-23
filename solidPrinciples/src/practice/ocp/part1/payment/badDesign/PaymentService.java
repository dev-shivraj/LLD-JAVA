package practice.ocp.part1.payment.badDesign;

public class PaymentService {

    public void processPayment(String type) {
        if (type.equals("CREDIT_CARD")) {
            System.out.println("Processing Credit Card");
        } else if (type.equals("UPI")) {
            System.out.println("Processing UPI");
        } else if (type.equals("PAYPAL")) {
            System.out.println("Processing PayPal");
        }
    }
}