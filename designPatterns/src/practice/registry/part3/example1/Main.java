package practice.registry.part3.example1;

import practice.registry.part3.example1.factory.PaymentFactory;
import practice.registry.part3.example1.processor.CreditCardPayment;
import practice.registry.part3.example1.processor.PayPalPayment;
import practice.registry.part3.example1.processor.UPIPayment;
import practice.registry.part3.example1.registry.PaymentCreatorRegistry;
import practice.registry.part3.example1.service.PaymentService;

public class Main {

    public static void main(String[] args) {
        PaymentCreatorRegistry registry = new PaymentCreatorRegistry();
        registry.register("credit-card", CreditCardPayment::new);
        registry.register("upi", UPIPayment::new);
        registry.register("paypal", PayPalPayment::new);


        PaymentFactory factory = new PaymentFactory(registry);
        PaymentService service = new PaymentService(factory);
        service.pay("upi", 500);
        service.pay("upi", 1000);
        service.pay("credit-card", 2000);
        service.pay("paypal", 3000);
    }
}