package practice.decorator.part5.example1.decorator;

import practice.decorator.part5.example1.component.Order;
import practice.decorator.part5.example1.component.OrderService;

public class LoggingDecorator extends OrderServiceDecorator {

    public LoggingDecorator(OrderService orderService) {
        super(orderService);
    }

    @Override
    public void createOrder(Order order) {

        System.out.println("[LOG] Creating order " + order.getOrderId());

        orderService.createOrder(order);

        System.out.println("[LOG] Order creation completed");
    }
}