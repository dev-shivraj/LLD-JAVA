package practice.factory.part1.simplefactory.factory;

import practice.factory.part1.simplefactory.payment.CreditCardPayment;
import practice.factory.part1.simplefactory.payment.PayPalPayment;
import practice.factory.part1.simplefactory.payment.Payment;
import practice.factory.part1.simplefactory.payment.UpiPayment;

public class PaymentFactory {
    public static Payment createPayment(String paymentType) {
        if(paymentType.equals("CREDIT_CARD")) {
            return new CreditCardPayment();
        } else if(paymentType.equals("UPI")) {
            return new UpiPayment();
        } else if(paymentType.equals("PAYPAL")) {
            return new PayPalPayment();
        } else {
            throw new IllegalArgumentException("Unsupported payment type: " + paymentType);
        }
    }
}
