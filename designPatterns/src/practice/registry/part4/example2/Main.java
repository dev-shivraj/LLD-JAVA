package practice.registry.part4.example2;

import practice.registry.part4.example2.processor.CreditCardPayment;
import practice.registry.part4.example2.processor.PaymentProcessor;
import practice.registry.part4.example2.processor.UPIPayment;
import practice.registry.part4.example2.registry.Registry;
import practice.registry.part4.example2.service.PaymentService;

public class Main {

    public static void main(String[] args) {
        Registry<PaymentProcessor> registry = new Registry<>();
        PaymentProcessor upi = new UPIPayment();
        PaymentProcessor creditCard = new CreditCardPayment();
        registry.register("upi", upi);
        registry.register("credit-card", creditCard);


        PaymentService service = new PaymentService(registry);
        service.pay("upi", 500);
        service.pay("upi", 1000);
        service.pay("credit-card", 2000);


        PaymentProcessor p1 = registry.get("upi");
        PaymentProcessor p2 = registry.get("upi");
        System.out.println("Same UPI object: " + (p1 == p2));
    }
}