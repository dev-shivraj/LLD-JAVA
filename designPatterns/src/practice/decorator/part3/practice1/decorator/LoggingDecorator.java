package practice.decorator.part3.practice1.decorator;

import practice.decorator.part3.practice1.component.OrderService;

public class LoggingDecorator extends OrderServiceDecorator {

    public LoggingDecorator(OrderService orderService) {
        super(orderService);
    }

    @Override
    public void createOrder(String orderId) {
        System.out.println("[LOG] Creating order: " + orderId);
        orderService.createOrder(orderId);
    }
}