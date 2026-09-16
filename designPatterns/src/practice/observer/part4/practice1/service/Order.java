package practice.observer.part4.practice1.service;

import practice.observer.part4.practice1.event.EventType;
import practice.observer.part4.practice1.event.OrderEvent;
import practice.observer.part4.practice1.subject.EventPublisher;

public class Order {

    private String orderId;
    private String customerId;

    private EventPublisher publisher;

    public Order(String orderId, String customerId, EventPublisher publisher) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.publisher = publisher;
    }

    public void place() {
        publish(EventType.ORDER_PLACED);
    }

    public void ship() {
        publish(EventType.ORDER_SHIPPED);
    }

    public void cancel() {
        publish(EventType.ORDER_CANCELLED);
    }

    private void publish(EventType type) {
        publisher.publish(new OrderEvent(type, orderId, customerId));
    }
}