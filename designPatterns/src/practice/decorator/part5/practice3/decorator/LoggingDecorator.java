package practice.decorator.part5.practice3.decorator;

import practice.decorator.part5.practice3.component.Order;
import practice.decorator.part5.practice3.component.RestaurantOrderService;

public class LoggingDecorator extends RestaurantOrderServiceDecorator {

    public LoggingDecorator(RestaurantOrderService orderService) {
        super(orderService);
    }

    @Override
    public void placeOrder(Order order) {
        System.out.println("[LOG] Order request received");

        orderService.placeOrder(order);

        System.out.println("[LOG] Order processing completed");
    }
}