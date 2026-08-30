package practice.lsp.part2.postCondition.payment.badDesign;

public class PaymentClient {
    public static void main(String[] args) {
        Payment payment = new CreditCardPayment();
        boolean result = payment.processPayment(1000);
        System.out.println("Payment successful: " + result);
    }
}