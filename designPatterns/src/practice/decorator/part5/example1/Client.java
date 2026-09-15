package practice.decorator.part5.example1;

import practice.decorator.part5.example1.component.BasicOrderService;
import practice.decorator.part5.example1.component.Order;
import practice.decorator.part5.example1.component.OrderService;
import practice.decorator.part5.example1.decorator.AuditDecorator;
import practice.decorator.part5.example1.decorator.LoggingDecorator;
import practice.decorator.part5.example1.decorator.MetricsDecorator;
import practice.decorator.part5.example1.decorator.ValidationDecorator;

public class Client {

    public static void main(String[] args) {
        OrderService orderService = new BasicOrderService();

        orderService = new MetricsDecorator(orderService);
        orderService = new AuditDecorator(orderService);
        orderService = new ValidationDecorator(orderService);
        orderService = new LoggingDecorator(orderService);

        Order order = new Order("ORD-101", "Shivraj", 2500);

        orderService.createOrder(order);
    }
}