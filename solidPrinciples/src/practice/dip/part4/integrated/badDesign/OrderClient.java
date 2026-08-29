package practice.dip.part4.integrated.badDesign;

public class OrderClient {
    public static void main(String[] args) {
        OrderService service = new OrderService();
        service.processOrder("ORD-101", 5000);
    }
}