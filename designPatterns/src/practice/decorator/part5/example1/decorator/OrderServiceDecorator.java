package practice.decorator.part5.example1.decorator;

import practice.decorator.part5.example1.component.Order;
import practice.decorator.part5.example1.component.OrderService;

public abstract class OrderServiceDecorator implements OrderService {

    protected final OrderService orderService;

    protected OrderServiceDecorator(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public void createOrder(Order order) {
        orderService.createOrder(order);
    }
}