package practice.observer.part3.practice2.event;

public class OrderEvent {

    private String orderId;
    private String customerId;
    private double amount;

    public OrderEvent(String orderId, String customerId, double amount) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.amount = amount;
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