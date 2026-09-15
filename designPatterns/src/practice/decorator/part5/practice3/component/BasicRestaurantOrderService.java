package practice.decorator.part5.practice3.component;

public class BasicRestaurantOrderService implements RestaurantOrderService {

    @Override
    public void placeOrder(Order order) {
        System.out.println("Restaurant order placed: " + order.getOrderId() + ", amount ₹" + order.getAmount());
    }
}