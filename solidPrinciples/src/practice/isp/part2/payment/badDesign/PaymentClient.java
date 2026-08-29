package practice.isp.part2.payment.badDesign;

public class PaymentClient {
    public static void main(String[] args) {
        Payment payment = new CreditCardPayment();
        payment.pay();
        payment.refund();
        payment.generateReceipt();
        payment.sendNotification();
        System.out.println("----------------");

        // CreditCardPayment does not support cash payment
        payment.payWithCash();
    }
}