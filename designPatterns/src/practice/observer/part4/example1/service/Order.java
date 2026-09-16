package practice.observer.part4.example1.service;

import practice.observer.part4.example1.event.EventType;
import practice.observer.part4.example1.event.OrderEvent;
import practice.observer.part4.example1.subject.EventPublisher;

public class Order {

    private String orderId;
    private String customerId;
    private double amount;

    private EventPublisher eventPublisher;

    public Order(String orderId, String customerId, double amount, EventPublisher eventPublisher) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.amount = amount;
        this.eventPublisher = eventPublisher;
    }

    public void place() {
        publish(EventType.ORDER_PLACED);
    }

    public void ship() {
        publish(EventType.ORDER_SHIPPED);
    }

    public void deliver() {
        publish(EventType.ORDER_DELIVERED);
    }

    public void cancel() {
        publish(EventType.ORDER_CANCELLED);
    }

    private void publish(EventType eventType) {
        OrderEvent event = new OrderEvent(eventType, orderId, customerId, amount);
        eventPublisher.publish(event);
    }
}