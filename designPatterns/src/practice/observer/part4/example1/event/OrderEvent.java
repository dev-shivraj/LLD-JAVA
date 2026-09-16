package practice.observer.part4.example1.event;

public class OrderEvent {

    private EventType type;
    private String orderId;
    private String customerId;
    private double amount;

    public OrderEvent(EventType type, String orderId, String customerId, double amount) {
        this.type = type;
        this.orderId = orderId;
        this.customerId = customerId;
        this.amount = amount;
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

    public double getAmount() {
        return amount;
    }
}