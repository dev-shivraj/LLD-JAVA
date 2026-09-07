package practice.registry.part4.practice3;

import practice.registry.part4.practice3.processor.CreditCardPayment;
import practice.registry.part4.practice3.processor.PayPalPayment;
import practice.registry.part4.practice3.processor.UPIPayment;
import practice.registry.part4.practice3.registry.ClassRegistry;

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
        System.out.println("Same Credit Card object: " + (creditCard == registeredCreditCard));
        System.out.println("Same PayPal object: " + (paypal == registeredPaypal));
    }
}