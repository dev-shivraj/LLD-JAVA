package practice.observer.part4.practice1.event;

public class OrderEvent {

    private EventType type;
    private String orderId;
    private String customerId;

    public OrderEvent(EventType type, String orderId, String customerId) {
        this.type = type;
        this.orderId = orderId;
        this.customerId = customerId;
    }

    public EventType getType() {
        return type;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getCustomerId() {
        return customerId;
    }
}