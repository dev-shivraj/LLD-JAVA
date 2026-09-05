package practice.factory.part1.badDesign;

public class Client {
    public static void main(String[] args) {
        PaymentService service = new PaymentService();

        service.processPayment("UPI", 1000);
    }
}
