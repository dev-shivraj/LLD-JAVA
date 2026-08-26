package practice.builder.part4.order;

public class OrderClient {

    public static void main(String[] args) {

        Order order = Order.builder()
                .setOrderId("ORD-1001")
                .setCustomerId("CUS-101")
                .addItem("Laptop")
                .addItem("Mouse")
                .setShippingAddress("Bangalore")
                .setBillingAddress("Bangalore")
                .setCouponCode("SAVE20")
                .setPaymentMethod("CARD")
                .setPriority("HIGH")
                .setGiftWrap(true)
                .setNotes("Birthday gift")
                .build();

        System.out.println("Order ID: "
                + order.getOrderId());

        System.out.println("Customer ID: "
                + order.getCustomerId());

        System.out.println("Items: "
                + order.getItems());

        System.out.println("Shipping Address: "
                + order.getShippingAddress());

        System.out.println("Billing Address: "
                + order.getBillingAddress());

        System.out.println("Coupon Code: "
                + order.getCouponCode());

        System.out.println("Payment Method: "
                + order.getPaymentMethod());

        System.out.println("Priority: "
                + order.getPriority());

        System.out.println("Gift Wrap: "
                + order.isGiftWrap());

        System.out.println("Notes: "
                + order.getNotes());
    }
}