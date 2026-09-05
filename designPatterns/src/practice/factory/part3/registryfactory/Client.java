package practice.factory.part3.registryfactory;

import practice.factory.part3.registryfactory.component.CreditCardPayment;
import practice.factory.part3.registryfactory.component.PayPalPayment;
import practice.factory.part3.registryfactory.component.Payment;
import practice.factory.part3.registryfactory.component.UpiPayment;
import practice.factory.part3.registryfactory.factory.PaymentFactory;

public class Client {
    public static void main(String[] args) {
        PaymentFactory factory = new PaymentFactory();
        factory.register(PaymentType.UPI, UpiPayment::new);
        factory.register(PaymentType.CARD, CreditCardPayment::new);
        factory.register(PaymentType.PAYPAL, PayPalPayment::new);

        Payment payment = factory.create(PaymentType.UPI);
        payment.pay(1000);
    }
}
