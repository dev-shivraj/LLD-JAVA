package practice.decorator.part3.practice1.decorator;

import practice.decorator.part3.practice1.component.OrderService;

public abstract class OrderServiceDecorator implements OrderService {

    protected OrderService orderService;

    protected OrderServiceDecorator(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public void createOrder(String orderId) {
        orderService.createOrder(orderId);
    }
}