package practice.adaptor.part1.payment;

import practice.adaptor.part1.payment.adaptor.RazorpayAdaptor;
import practice.adaptor.part1.payment.external.RazorpayGateway;
import practice.adaptor.part1.payment.service.PaymentService;

public class Client {
    public static void main(String[] args) {
        RazorpayGateway razorpayGateway = new RazorpayGateway();
        PaymentProcessor adaptor = new RazorpayAdaptor(razorpayGateway);

        PaymentService service = new PaymentService(adaptor);
        service.processPayment(1000);
    }
}
