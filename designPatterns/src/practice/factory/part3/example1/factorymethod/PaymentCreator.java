package practice.factory.part3.example1.factorymethod;

import practice.factory.part3.example1.processor.PaymentProcessor;

public abstract class PaymentCreator {

    public abstract PaymentProcessor createPayment();

    public void processPayment(double amount) {
        PaymentProcessor processor = createPayment();
        processor.pay(amount);
    }
}