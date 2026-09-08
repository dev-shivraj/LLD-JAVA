package practice.factory.part3.example1.factorymethod;

import practice.factory.part3.example1.processor.PaymentProcessor;
import practice.factory.part3.example1.processor.UPIPayment;

public class UpiPaymentCreator extends PaymentCreator {

    @Override
    public PaymentProcessor createPayment() {
        return new UPIPayment();
    }
}