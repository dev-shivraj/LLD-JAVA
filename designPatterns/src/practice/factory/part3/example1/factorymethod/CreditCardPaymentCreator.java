package practice.factory.part3.example1.factorymethod;

import practice.factory.part3.example1.processor.CreditCardPayment;
import practice.factory.part3.example1.processor.PaymentProcessor;

public class CreditCardPaymentCreator extends PaymentCreator {

    @Override
    public PaymentProcessor createPayment() {
        return new CreditCardPayment();
    }
}