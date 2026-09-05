package practice.adaptor.part1.payment;

import practice.adaptor.part1.payment.adaptor.RazorpayAdaptor;
import practice.adaptor.part1.payment.adaptor.StripeAdaptor;
import practice.adaptor.part1.payment.external.RazorpayGateway;
import practice.adaptor.part1.payment.external.StripeGateway;
import practice.adaptor.part1.payment.service.PaymentService;

public class Client {
    public static void main(String[] args) {
        // ================================================================================
//        RazorpayGateway razorpayGateway = new RazorpayGateway();
//        PaymentProcessor adaptor = new RazorpayAdaptor(razorpayGateway);
//
//        PaymentService service = new PaymentService(adaptor);
//        service.processPayment(1000);

        // ================================================================================

        // =========  some more external service integrated through the adaptor ===========

        StripeGateway gateway = new StripeGateway();
        PaymentProcessor adaptor = new StripeAdaptor(gateway);

        PaymentService paymentService = new PaymentService(adaptor);
        paymentService.processPayment(3000);



        System.out.println("---------------------------------");
        RazorpayGateway razorpayGateway = new RazorpayGateway();
        adaptor = new RazorpayAdaptor(razorpayGateway);
        paymentService = new PaymentService(adaptor);
        paymentService.processPayment(5000);
        // ================================================================================
    }
}
