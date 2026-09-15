package practice.decorator.part5.example1.component;

public class BasicOrderService implements OrderService {

    @Override
    public void createOrder(Order order) {

        System.out.println("Order created: " + order.getOrderId());
    }
}