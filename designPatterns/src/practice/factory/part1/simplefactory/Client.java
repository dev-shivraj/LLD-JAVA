package practice.factory.part1.simplefactory;

public class Client {
    public static void main(String[] args) {
        PaymentService paymentService = new PaymentService();
        paymentService.processPayment("UPI", 1000);
        paymentService.processPayment("CREDIT_CARD", 5000);
        paymentService.processPayment("PAYPAL", 2000);
    }
}
