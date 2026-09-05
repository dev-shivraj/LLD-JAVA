package practice.factory.part3.registryfactory;

import practice.factory.part3.registryfactory.component.CreditCardPayment;
import practice.factory.part3.registryfactory.component.PayPalPayment;
import practice.factory.part3.registryfactory.component.Payment;
import practice.factory.part3.registryfactory.component.UpiPayment;
import practice.factory.part3.registryfactory.factory.PaymentFactory;

public class Client {
    public static void main(String[] args) {
        PaymentFactory factory = new PaymentFactory();
        factory.register("UPI", UpiPayment::new);
        factory.register("CARD", CreditCardPayment::new);
        factory.register("PAYPAL", PayPalPayment::new);

        Payment payment = factory.create("UPI");
        payment.pay(1000);
    }
}
