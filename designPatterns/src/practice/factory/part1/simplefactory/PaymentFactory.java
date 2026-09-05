package practice.factory.part1.simplefactory;

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
