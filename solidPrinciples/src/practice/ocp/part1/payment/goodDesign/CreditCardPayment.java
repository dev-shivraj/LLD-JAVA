package practice.ocp.part1.payment.goodDesign;

public class CreditCardPayment implements Payment{
    @Override
    public void process() {
        System.out.println("Processing Credit Card payment");
    }
}
