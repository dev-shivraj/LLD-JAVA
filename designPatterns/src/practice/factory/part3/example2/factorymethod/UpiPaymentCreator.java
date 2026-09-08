package practice.factory.part3.example2.factorymethod;

import practice.factory.part3.example2.processor.PaymentProcessor;
import practice.factory.part3.example2.processor.UPIPayment;

public class UpiPaymentCreator extends PaymentCreator {

    @Override
    protected PaymentProcessor createPayment() {
        return new UPIPayment();
    }
}