package inventory_management_system.orders;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
Process orders by prioritizing express orders using a PriorityQueue.
Objective: Process orders by prioritizing express orders using a PriorityQueue.
Tasks:
    Create the Order Class:
    Attributes:
    String orderId.
    boolean isExpress (true for express orders, false for regular ones).
    Implement the Order Queue:
    Use PriorityQueue<Order> to store orders.
    Write Methods for Order Queue:
    addOrder(Order order): Add an order to the queue.
    processOrder(): Process and remove the highest-priority order (express orders first).
    Test Order Queue:
    Add multiple express and regular orders.
    Test if express orders are processed first.

 */
public class Order implements Comparable<Order> {
    private String orderId;
    private boolean isExpress;

    public Order(String orderId, boolean isExpress) {
        this.orderId = orderId;
        this.isExpress = isExpress;
    }

    public boolean isExpress() {
        return isExpress;
    }

    public void setExpress(boolean express) {
        isExpress = express;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", isExpress=" + isExpress +
                '}';
    }

    @Override
    public int compareTo(Order o) {
        if(this.isExpress && o.isExpress) {
            return this.orderId.compareTo(o.orderId);
        }
        if(this.isExpress) {
            return -1;
        }
        return 1;
    }

}
