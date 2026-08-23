package practice.ocp.part1.payment.goodDesign;

public class UpiPayment implements Payment {
    @Override
    public void process() {
        System.out.println("Processing UPI payment");
    }
}
