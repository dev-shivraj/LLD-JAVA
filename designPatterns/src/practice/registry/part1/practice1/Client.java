package practice.registry.part1.practice1;

import practice.registry.part1.practice1.registry.PaymentRegistry;
import practice.registry.part1.practice1.processor.CreditCardPayment;
import practice.registry.part1.practice1.processor.PaymentProcessor;
import practice.registry.part1.practice1.processor.PaypalPayment;
import practice.registry.part1.practice1.processor.UPIPayment;

public class Client {
    public static void main(String[] args) {
        PaymentRegistry registry = new PaymentRegistry();
        registry.register("CREDIT_CARD", new CreditCardPayment());
        registry.register("UPI", new UPIPayment());
        registry.register("PAYPAL", new PaypalPayment());


        PaymentProcessor creditCardProcessor = registry.get("CREDIT_CARD");
        creditCardProcessor.pay(1000);

        PaymentProcessor upiProcessor = registry.get("UPI");
        upiProcessor.pay(5000);

        PaymentProcessor paypalProcessor = registry.get("PAYPAL");
        paypalProcessor.pay(3000);


    }
}
