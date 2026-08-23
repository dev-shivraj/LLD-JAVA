package practice.ocp.part2.payment.goodDesign;

public class CreditCardPayment implements Payment {

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing Credit Card payment: " + amount);
    }
}