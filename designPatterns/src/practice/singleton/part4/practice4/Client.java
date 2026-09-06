package practice.singleton.part4.practice4;

public class Client {
    public static void main(String[] args) {
        PaymentService realPayment = new RealPaymentService();
        OrderService productionOrder = new OrderService(realPayment);
        productionOrder.placeOrder();

        PaymentService mockPayment = new MockPaymentService();
        OrderService testOrder = new OrderService(mockPayment);
        testOrder.placeOrder();
    }
}