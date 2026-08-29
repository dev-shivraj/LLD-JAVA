package practice.dip.part2.setterInjection;

public class PaymentClient {
    public static void main(String[] args) {
        PaymentService service = new PaymentService();
        service.setPaymentGateway(new StripePayment());
        service.processPayment();
        System.out.println("----------------");

        service.setPaymentGateway(new RazorpayPayment());
        service.processPayment();
    }
}