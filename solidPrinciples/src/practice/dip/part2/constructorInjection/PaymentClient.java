package practice.dip.part2.constructorInjection;

public class PaymentClient {
    public static void main(String[] args) {
        PaymentGateway stripePayment = new StripePayment();
        PaymentService stripeService = new PaymentService(stripePayment);
        stripeService.processPayment();
        System.out.println("----------------");

        PaymentGateway razorpayPayment = new RazorpayPayment();
        PaymentService razorpayService = new PaymentService(razorpayPayment);
        razorpayService.processPayment();
    }
}