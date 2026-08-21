package practice.introduction.payment;

class PaymentProcessor {

    void process(String paymentType) {

        if (paymentType.equals("CARD")) {
            System.out.println("CARD payment done");
        } else if (paymentType.equals("UPI")) {
            System.out.println("UP payment done");
        } else if (paymentType.equals("PAYPAL")) {
            System.out.println("PAYPAL payment done");
        }
    }
}