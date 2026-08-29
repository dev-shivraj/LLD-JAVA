package practice.isp.part1.payment.goodDesign;

public class Client {
    public static void main(String[] args) {
        CreditCardPayment creditCardPayment = new CreditCardPayment();
        creditCardPayment.pay();
        creditCardPayment.refund();
    }
}
