package practice.ocp.part2.payment.goodDesign;

public class UPIPayment implements Payment {

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing UPI payment: " + amount);
    }
}