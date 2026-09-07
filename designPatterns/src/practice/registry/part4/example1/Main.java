package practice.registry.part4.example1;

import practice.registry.part4.example1.factory.PaymentFactory;
import practice.registry.part4.example1.processor.CreditCardPayment;
import practice.registry.part4.example1.processor.PayPalPayment;
import practice.registry.part4.example1.processor.PaymentProcessor;
import practice.registry.part4.example1.processor.UPIPayment;
import practice.registry.part4.example1.registry.Registry;

public class Main {

    public static void main(String[] args) {
        Registry<PaymentProcessor> registry = new Registry<>();
        registry.register("credit-card", CreditCardPayment::new);
        registry.register("upi", UPIPayment::new);
        registry.register("paypal", PayPalPayment::new);


        PaymentFactory factory = new PaymentFactory(registry);


        PaymentProcessor payment1 = factory.create("upi");
        payment1.pay(500);

        PaymentProcessor payment2 = factory.create("upi");
        payment2.pay(1000);

        PaymentProcessor payment3 = factory.create("credit-card");
        payment3.pay(2000);

        PaymentProcessor payment4 = factory.create("paypal");
        payment4.pay(3000);
    }
}