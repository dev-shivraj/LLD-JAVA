package practice.lsp.part1.payment.goodDesign;

public class PaymentClient {
    public static void processPayment(Payment payment) {
        payment.pay();
    }

    public static void processRefund(RefundablePayment payment) {
        payment.refund();
    }

    public static void main(String[] args) {
        Payment cashPayment = new CashPayment();
        processPayment(cashPayment);

        RefundablePayment creditCardPayment = new CreditCardPayment();
        processPayment(creditCardPayment);
        processRefund(creditCardPayment);
    }
}