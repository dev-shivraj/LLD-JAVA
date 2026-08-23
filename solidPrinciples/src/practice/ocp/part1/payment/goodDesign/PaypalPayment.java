package practice.ocp.part1.payment.goodDesign;

public class PaypalPayment implements Payment{
    @Override
    public void process() {
        System.out.println("Processing Paypal payment");
    }
}
