package practice.facade.part2.ecommerce.services;

import practice.facade.part2.ecommerce.record.Cart;

public class OrderService {
    public String createOrder(Cart cart, double amount) {
        String orderId = "ORD-1001";
        System.out.println("Creating order: " + orderId);

        return orderId;
    }
}