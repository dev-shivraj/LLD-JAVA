package practice.ocp.part2.payment.goodDesign;

public class PaypalPayment implements Payment {

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing PayPal payment: " + amount);
    }
}