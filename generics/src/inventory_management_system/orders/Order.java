package inventory_management_system.orders;

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
