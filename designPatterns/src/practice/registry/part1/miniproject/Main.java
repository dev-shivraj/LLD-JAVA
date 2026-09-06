package practice.registry.part1.miniproject;

import practice.registry.part1.miniproject.factory.PaymentRegistry;
import practice.registry.part1.miniproject.processor.CreditCardProcessor;
import practice.registry.part1.miniproject.processor.UpiProcessor;
import practice.registry.part1.miniproject.processor.WalletProcessor;
import practice.registry.part1.miniproject.service.PaymentService;

public class Main {
    public static void main(String[] args) {
        PaymentRegistry registry = new PaymentRegistry();
        registry.register("credit_card", new CreditCardProcessor());
        registry.register("upi", new UpiProcessor());
        registry.register("wallet", new WalletProcessor());


        PaymentService service = new PaymentService(registry);
        service.pay("upi", 5000);
        service.pay("credit_card", 10000);
        service.pay("wallet", 2000);
    }
}