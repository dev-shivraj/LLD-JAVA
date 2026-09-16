package practice.observer.part3.example1.event;

public class OrderEvent {

    private String orderId;
    private String customerId;
    private double amount;
    private String status;

    public OrderEvent(String orderId, String customerId, double amount, String status) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.amount = amount;
        this.status = status;
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

    public String getStatus() {
        return status;
    }
}