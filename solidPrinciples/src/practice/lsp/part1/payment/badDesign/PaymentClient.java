package practice.lsp.part1.payment.badDesign;

public class PaymentClient {
    public static void processRefund(Payment payment) {
        payment.refund();
    }

    public static void main(String[] args) {
        Payment creditCardPayment = new CreditCardPayment();
        processRefund(creditCardPayment);

        Payment cashPayment = new CashPayment();
        processRefund(cashPayment);
    }
}