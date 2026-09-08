package practice.factory.part3.example1;

import practice.factory.part3.example1.factorymethod.CreditCardPaymentCreator;
import practice.factory.part3.example1.factorymethod.PaymentCreator;
import practice.factory.part3.example1.factorymethod.UpiPaymentCreator;

public class Main {
    public static void main(String[] args) {
        PaymentCreator upiCreator = new UpiPaymentCreator();
        upiCreator.processPayment(500);
        System.out.println();

        PaymentCreator cardCreator = new CreditCardPaymentCreator();
        cardCreator.processPayment(1000);
    }
}