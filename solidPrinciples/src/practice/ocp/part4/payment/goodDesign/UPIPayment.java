package practice.ocp.part4.payment.goodDesign;

public class UPIPayment implements Payment {

    @Override
    public void process(double amount) {
        System.out.println("Processing UPI: " + amount);
    }
}