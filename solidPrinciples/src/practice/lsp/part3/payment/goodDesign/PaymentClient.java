package practice.lsp.part3.payment.goodDesign;

public class PaymentClient {
    public static void main(String[] args) {
        Payment cashPayment = new CashPayment();
        cashPayment.process();
        System.out.println("----------------");

        CreditCardPayment creditCardPayment = new CreditCardPayment();
        creditCardPayment.process();
        creditCardPayment.refund();
    }
}