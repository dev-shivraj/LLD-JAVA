package practice.decorator.part5.practice3.decorator;

import practice.decorator.part5.practice3.component.Order;
import practice.decorator.part5.practice3.component.RestaurantOrderService;

public class ValidationDecorator
        extends RestaurantOrderServiceDecorator {

    public ValidationDecorator(
            RestaurantOrderService orderService
    ) {
        super(orderService);
    }

    @Override
    public void placeOrder(Order order) {

        if (order == null) {
            throw new IllegalArgumentException(
                    "Order cannot be null"
            );
        }

        if (order.getAmount() <= 0) {
            throw new IllegalArgumentException(
                    "Order amount must be positive"
            );
        }

        System.out.println("[VALIDATION] Order valid");

        orderService.placeOrder(order);
    }
}