package practice.decorator.part5.practice3.decorator;

import practice.decorator.part5.practice3.component.Order;
import practice.decorator.part5.practice3.component.RestaurantOrderService;

public abstract class RestaurantOrderServiceDecorator implements RestaurantOrderService {

    protected final RestaurantOrderService orderService;

    protected RestaurantOrderServiceDecorator(RestaurantOrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public void placeOrder(Order order) {
        orderService.placeOrder(order);
    }
}