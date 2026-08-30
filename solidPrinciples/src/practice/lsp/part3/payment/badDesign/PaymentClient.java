package practice.lsp.part3.payment.badDesign;

public class PaymentClient {
    public static void main(String[] args) {
        Payment payment = new CashPayment();
        payment.process();
        payment.refund();
    }
}