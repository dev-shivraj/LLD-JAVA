package inventory_management_system.orders;

import java.util.PriorityQueue;

public class OrderProcessor {
    private PriorityQueue<Order> orderQueue;

    public OrderProcessor() {
        orderQueue = new PriorityQueue<>();
    }

    public void addOrder(Order order) {
        orderQueue.offer(order);
    }

    public Order processOrder() {
        return orderQueue.poll();
    }
}
