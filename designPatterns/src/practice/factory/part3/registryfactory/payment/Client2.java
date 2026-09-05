package practice.factory.part3.registryfactory.payment;

import practice.factory.part3.registryfactory.payment.component.CreditCardPayment;
import practice.factory.part3.registryfactory.payment.component.UpiPayment;
import practice.factory.part3.registryfactory.payment.enums.PaymentType;
import practice.factory.part3.registryfactory.payment.factory.PaymentFactory;
import practice.factory.part3.registryfactory.payment.service.PaymentService;

public class Client2 {
    public static void main(String[] args) {
        PaymentFactory factory = new PaymentFactory();
        factory.register(PaymentType.UPI, UpiPayment::new);
        factory.register(PaymentType.CARD, CreditCardPayment::new);

        PaymentService service = new PaymentService(factory);
        service.process(PaymentType.CARD, 2000);
    }
}
