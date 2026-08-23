package practice.ocp.part4.payment.badDesign;

public class PaymentService {

    public void processPayment(String type, double amount) {

        if (type.equals("UPI")) {
            System.out.println("Processing UPI: " + amount);
        } else if (type.equals("CARD")) {
            System.out.println("Processing Card: " + amount);
        } else if (type.equals("PAYPAL")) {
            System.out.println("Processing PayPal: " + amount);
        }
    }
}