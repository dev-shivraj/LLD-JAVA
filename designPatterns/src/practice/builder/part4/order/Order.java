package practice.builder.part4.order;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private final String orderId;
    private final String customerId;
    private final List<String> items;
    private final String shippingAddress;
    private final String billingAddress;
    private final String couponCode;
    private final String paymentMethod;
    private final String priority;
    private final boolean giftWrap;
    private final String notes;

    private Order(
            String orderId,
            String customerId,
            List<String> items,
            String shippingAddress,
            String billingAddress,
            String couponCode,
            String paymentMethod,
            String priority,
            boolean giftWrap,
            String notes
    ) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.items = List.copyOf(items);
        this.shippingAddress = shippingAddress;
        this.billingAddress = billingAddress;
        this.couponCode = couponCode;
        this.paymentMethod = paymentMethod;
        this.priority = priority;
        this.giftWrap = giftWrap;
        this.notes = notes;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getOrderId() {
        return orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public List<String> getItems() {
        return items;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public String getPriority() {
        return priority;
    }

    public boolean isGiftWrap() {
        return giftWrap;
    }

    public String getNotes() {
        return notes;
    }

    public static class Builder {

        private String orderId;
        private String customerId;
        private final List<String> items = new ArrayList<>();
        private String shippingAddress;
        private String billingAddress;
        private String couponCode;
        private String paymentMethod;
        private String priority = "NORMAL";
        private boolean giftWrap = false;
        private String notes;

        public Builder setOrderId(String orderId) {
            this.orderId = orderId;
            return this;
        }

        public Builder setCustomerId(String customerId) {
            this.customerId = customerId;
            return this;
        }

        public Builder addItem(String item) {
            this.items.add(item);
            return this;
        }

        public Builder setShippingAddress(String shippingAddress) {
            this.shippingAddress = shippingAddress;
            return this;
        }

        public Builder setBillingAddress(String billingAddress) {
            this.billingAddress = billingAddress;
            return this;
        }

        public Builder setCouponCode(String couponCode) {
            this.couponCode = couponCode;
            return this;
        }

        public Builder setPaymentMethod(String paymentMethod) {
            this.paymentMethod = paymentMethod;
            return this;
        }

        public Builder setPriority(String priority) {
            this.priority = priority;
            return this;
        }

        public Builder setGiftWrap(boolean giftWrap) {
            this.giftWrap = giftWrap;
            return this;
        }

        public Builder setNotes(String notes) {
            this.notes = notes;
            return this;
        }

        public Order build() {

            // Required field validation
            if (orderId == null || orderId.isBlank()) {
                throw new IllegalArgumentException(
                        "Order ID is required"
                );
            }

            if (customerId == null || customerId.isBlank()) {
                throw new IllegalArgumentException(
                        "Customer ID is required"
                );
            }

            // At least one item is required
            if (items.isEmpty()) {
                throw new IllegalArgumentException(
                        "Order must contain at least one item"
                );
            }

            // Cross-field validation
            if (giftWrap &&
                    (shippingAddress == null ||
                     shippingAddress.isBlank())) {

                throw new IllegalArgumentException(
                        "Shipping address is required for gift-wrapped orders"
                );
            }

            return new Order(
                    orderId,
                    customerId,
                    items,
                    shippingAddress,
                    billingAddress,
                    couponCode,
                    paymentMethod,
                    priority,
                    giftWrap,
                    notes
            );
        }
    }
}