package practice.ocp.part4.payment.goodDesign;

public class CardPayment implements Payment {

    @Override
    public void process(double amount) {
        System.out.println("Processing Card: " + amount);
    }
}