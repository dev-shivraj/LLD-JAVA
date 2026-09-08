package practice.factory.part3.example2;

import practice.factory.part3.example2.factorymethod.CreditCardPaymentCreator;
import practice.factory.part3.example2.factorymethod.PayPalPaymentCreator;
import practice.factory.part3.example2.factorymethod.PaymentCreator;
import practice.factory.part3.example2.factorymethod.UpiPaymentCreator;

public class Main {

    public static void main(String[] args) {
        PaymentCreator upiCreator = new UpiPaymentCreator();
        upiCreator.processPayment(500);
        System.out.println();

        PaymentCreator cardCreator = new CreditCardPaymentCreator();
        cardCreator.processPayment(1000);
        System.out.println();

        PaymentCreator paypalCreator = new PayPalPaymentCreator();
        paypalCreator.processPayment(1500);
    }
}