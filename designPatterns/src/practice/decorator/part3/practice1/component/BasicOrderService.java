package practice.decorator.part3.practice1.component;

public class BasicOrderService implements OrderService {

    @Override
    public void createOrder(String orderId) {
        System.out.println("Creating order: " + orderId);
    }
}