package practice.factory.part3.example2.factorymethod;

import practice.factory.part3.example2.processor.PayPalPayment;
import practice.factory.part3.example2.processor.PaymentProcessor;

public class PayPalPaymentCreator extends PaymentCreator {

    @Override
    protected PaymentProcessor createPayment() {
        return new PayPalPayment();
    }
}