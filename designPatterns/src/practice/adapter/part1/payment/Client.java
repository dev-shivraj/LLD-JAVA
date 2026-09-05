package practice.adapter.part1.payment;

import practice.adapter.part1.payment.adapter.RazorpayAdapter;
import practice.adapter.part1.payment.adapter.StripeAdapter;
import practice.adapter.part1.payment.external.RazorpayGateway;
import practice.adapter.part1.payment.external.StripeGateway;
import practice.adapter.part1.payment.service.CheckoutService;

public class Client {
    public static void main(String[] args) {
        // ================================================================================
//        RazorpayGateway razorpayGateway = new RazorpayGateway();
//        PaymentProcessor adaptor = new RazorpayAdaptor(razorpayGateway);
//
//        PaymentService service = new PaymentService(adaptor);
//        service.checkout(1000);

        // ================================================================================

        // =========  some more external service integrated through the adaptor ===========

        StripeGateway gateway = new StripeGateway();
        PaymentProcessor adaptor = new StripeAdapter(gateway);

        CheckoutService checkoutService = new CheckoutService(adaptor);
        checkoutService.checkout(3000);



        System.out.println("---------------------------------");
        RazorpayGateway razorpayGateway = new RazorpayGateway();
        adaptor = new RazorpayAdapter(razorpayGateway);
        checkoutService = new CheckoutService(adaptor);
        checkoutService.checkout(5000);
        // ================================================================================
    }
}
