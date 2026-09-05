package practice.factory.part1.badDesign;

class PaymentService {
    public void processPayment(String paymentType, double amount) {
        Payment payment;

        if (paymentType.equals("CREDIT_CARD")) {
            payment = new CreditCardPayment();
        } else if (paymentType.equals("UPI")) {
            payment = new UpiPayment();
        } else if (paymentType.equals("PAYPAL")) {
            payment = new PayPalPayment();
        } else {
            throw new IllegalArgumentException("Unsupported payment type");
        }

        payment.pay(amount);
    }
}