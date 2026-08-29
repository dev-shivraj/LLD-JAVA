package practice.dip.part1.payment.goodDesign;

public class PaymentClient {
    public static void main(String[] args) {
        PaymentGateway gateway = new StripePayment();
        PaymentService service = new PaymentService(gateway);
        service.processPayment();
        System.out.println("----------------");

        gateway = new RazorpayPayment();
        service = new PaymentService(gateway);
        service.processPayment();
    }
}