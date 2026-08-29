package practice.dip.part2.methodInjection;

public class PaymentClient {
    public static void main(String[] args) {
        PaymentService service = new PaymentService();
        service.processPayment(new StripePayment());
        System.out.println("----------------");

        service.processPayment(new RazorpayPayment());
    }
}