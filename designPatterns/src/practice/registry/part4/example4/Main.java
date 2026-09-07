package practice.registry.part4.example4;

import practice.registry.part4.example4.processor.CreditCardPayment;
import practice.registry.part4.example4.processor.PayPalPayment;
import practice.registry.part4.example4.processor.UPIPayment;
import practice.registry.part4.example4.registry.ClassRegistry;

public class Main {

    public static void main(String[] args) {
        ClassRegistry registry = new ClassRegistry();
        UPIPayment upi = new UPIPayment();
        CreditCardPayment creditCard = new CreditCardPayment();
        PayPalPayment paypal = new PayPalPayment();


        registry.register(UPIPayment.class, upi);
        registry.register(CreditCardPayment.class, creditCard);
        registry.register(PayPalPayment.class, paypal);


        UPIPayment registeredUpi = registry.get(UPIPayment.class);
        CreditCardPayment registeredCreditCard = registry.get(CreditCardPayment.class);
        PayPalPayment registeredPaypal = registry.get(PayPalPayment.class);


        registeredUpi.pay(500);
        registeredCreditCard.pay(1000);
        registeredPaypal.pay(1500);


        System.out.println("Same UPI object: " + (upi == registeredUpi));
    }
}