package practice.lsp.part2.preCondition.payment.goodDesign;

public class PaymentClient {
    public static void main(String[] args) {
        Payment payment = new CreditCardPayment();
        payment.processPayment(100);
    }
}