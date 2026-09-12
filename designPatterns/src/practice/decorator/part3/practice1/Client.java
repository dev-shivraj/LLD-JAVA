package practice.decorator.part3.practice1;

import practice.decorator.part3.practice1.component.BasicOrderService;
import practice.decorator.part3.practice1.component.OrderService;
import practice.decorator.part3.practice1.decorator.AuditDecorator;
import practice.decorator.part3.practice1.decorator.LoggingDecorator;

public class Client {

    public static void main(String[] args) {
        OrderService orderService = new BasicOrderService();
        orderService = new AuditDecorator(orderService);
        orderService = new LoggingDecorator(orderService);
        orderService.createOrder("ORD-101");
    }
}