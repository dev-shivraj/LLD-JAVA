package practice.dip.part1.payment.badDesign;

public class PaymentClient {
    public static void main(String[] args) {
        PaymentService service = new PaymentService();
        service.processPayment();
    }
}