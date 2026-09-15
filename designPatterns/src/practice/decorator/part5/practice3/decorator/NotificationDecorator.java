package practice.decorator.part5.practice3.decorator;

import practice.decorator.part5.practice3.component.Order;
import practice.decorator.part5.practice3.component.RestaurantOrderService;

public class NotificationDecorator
        extends RestaurantOrderServiceDecorator {

    public NotificationDecorator(
            RestaurantOrderService orderService
    ) {
        super(orderService);
    }

    @Override
    public void placeOrder(Order order) {

        orderService.placeOrder(order);

        System.out.println(
                "[NOTIFICATION] Customer notified"
        );
    }
}