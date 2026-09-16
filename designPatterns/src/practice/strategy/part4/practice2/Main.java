package practice.strategy.part4.practice2;

import practice.strategy.part4.practice2.factory.PaymentFactory;
import practice.strategy.part4.practice2.registry.PaymentRegistry;
import practice.strategy.part4.practice2.service.PaymentService;

public class Main {

    public static void main(String[] args) {

        PaymentFactory factory = new PaymentFactory();
        PaymentRegistry registry = new PaymentRegistry();

        registry.register("UPI",factory.create("UPI"));
        registry.register("CARD", factory.create("CARD"));
        registry.register("WALLET", factory.create("WALLET"));

        PaymentService service =new PaymentService(registry);
        service.pay("UPI", 1000);
        service.pay("CARD", 2000);
        service.pay("WALLET", 500);
    }
}