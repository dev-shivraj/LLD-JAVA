package practice.isp.part1.payment.badDesign;

public class Client {
    public static void main(String[] args) {
        CreditCardPayment creditCardPayment = new CreditCardPayment();
        creditCardPayment.pay();
        creditCardPayment.refund();
        creditCardPayment.payWithCash();
    }
}
