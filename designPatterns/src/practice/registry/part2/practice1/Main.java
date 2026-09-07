package practice.registry.part2.practice1;

import practice.registry.part2.practice1.processor.CreditCardPayment;
import practice.registry.part2.practice1.processor.PayPalPayment;
import practice.registry.part2.practice1.processor.UPIPayment;
import practice.registry.part2.practice1.registry.PaymentRegistry;
import practice.registry.part2.practice1.service.PaymentService;

public class Main {

    public static void main(String[] args) {
        PaymentRegistry registry = new PaymentRegistry();
        registry.register("credit-card", new CreditCardPayment());
        registry.register("upi", new UPIPayment());
        registry.register("paypal", new PayPalPayment());

        PaymentService service = new PaymentService(registry);
        service.pay("credit-card", 1000);
        service.pay("upi", 500);
        service.pay("paypal", 750);
    }
}