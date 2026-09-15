package practice.decorator.part5.example1.decorator;

import practice.decorator.part5.example1.component.Order;
import practice.decorator.part5.example1.component.OrderService;

public class AuditDecorator extends OrderServiceDecorator {

    public AuditDecorator(OrderService orderService) {
        super(orderService);
    }

    @Override
    public void createOrder(Order order) {

        System.out.println("[AUDIT] Order creation requested by " + order.getCustomerName());

        orderService.createOrder(order);

        System.out.println("[AUDIT] Order creation recorded");
    }
}