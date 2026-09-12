package practice.decorator.part3.practice1.decorator;

import practice.decorator.part3.practice1.component.OrderService;

public class AuditDecorator extends OrderServiceDecorator {

    public AuditDecorator(OrderService orderService) {
        super(orderService);
    }

    @Override
    public void createOrder(String orderId) {
        System.out.println("[AUDIT] Order creation started");
        orderService.createOrder(orderId);
        System.out.println("[AUDIT] Order creation completed");
    }
}