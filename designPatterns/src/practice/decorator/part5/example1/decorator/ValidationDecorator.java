package practice.decorator.part5.example1.decorator;

import practice.decorator.part5.example1.component.Order;
import practice.decorator.part5.example1.component.OrderService;

public class ValidationDecorator extends OrderServiceDecorator {

    public ValidationDecorator(OrderService orderService) {
        super(orderService);
    }

    @Override
    public void createOrder(Order order) {

        if (order == null) {
            throw new IllegalArgumentException("Order cannot be null");
        }

        if (order.getOrderId() == null || order.getOrderId().isBlank()) {
            throw new IllegalArgumentException("Order ID cannot be empty");
        }

        if (order.getCustomerName() == null || order.getCustomerName().isBlank()) {
            throw new IllegalArgumentException("Customer name cannot be empty");
        }

        if (order.getAmount() <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero");
        }

        System.out.println("[VALIDATION] Order is valid");

        orderService.createOrder(order);
    }
}