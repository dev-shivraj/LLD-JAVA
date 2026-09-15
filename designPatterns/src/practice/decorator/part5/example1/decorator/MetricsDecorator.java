package practice.decorator.part5.example1.decorator;

import practice.decorator.part5.example1.component.Order;
import practice.decorator.part5.example1.component.OrderService;

public class MetricsDecorator
        extends OrderServiceDecorator {

    public MetricsDecorator(OrderService orderService) {
        super(orderService);
    }

    @Override
    public void createOrder(Order order) {

        long startTime = System.currentTimeMillis();
        orderService.createOrder(order);
        long endTime = System.currentTimeMillis();

        System.out.println("[METRICS] createOrder took " + (endTime - startTime) + " ms");
    }
}