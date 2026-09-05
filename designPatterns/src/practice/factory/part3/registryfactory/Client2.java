package practice.factory.part3.registryfactory;

import practice.factory.part3.registryfactory.component.CreditCardPayment;
import practice.factory.part3.registryfactory.component.UpiPayment;
import practice.factory.part3.registryfactory.factory.PaymentFactory;
import practice.factory.part3.registryfactory.service.PaymentService;

public class Client2 {
    public static void main(String[] args) {
        PaymentFactory factory = new PaymentFactory();
        factory.register(PaymentType.UPI, UpiPayment::new);
        factory.register(PaymentType.CARD, CreditCardPayment::new);

        PaymentService service = new PaymentService(factory);
        service.process(PaymentType.CARD, 2000);
    }
}
