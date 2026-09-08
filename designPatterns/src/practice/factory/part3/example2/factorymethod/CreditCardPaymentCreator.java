package practice.factory.part3.example2.factorymethod;

import practice.factory.part3.example2.processor.CreditCardPayment;
import practice.factory.part3.example2.processor.PaymentProcessor;

public class CreditCardPaymentCreator extends PaymentCreator {

    @Override
    protected PaymentProcessor createPayment() {
        return new CreditCardPayment();
    }
}