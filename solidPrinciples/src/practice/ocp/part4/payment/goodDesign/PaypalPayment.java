package practice.ocp.part4.payment.goodDesign;

public class PaypalPayment implements Payment {

    @Override
    public void process(double amount) {
        System.out.println("Processing PayPal: " + amount);
    }
}