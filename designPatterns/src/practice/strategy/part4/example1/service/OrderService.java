package practice.strategy.part4.example1.service;

import practice.strategy.part4.example1.component.Order;
import practice.strategy.part4.example1.strategy.delivery.DeliveryStrategy;
import practice.strategy.part4.example1.strategy.discount.DiscountStrategy;
import practice.strategy.part4.example1.strategy.payment.PaymentStrategy;

public class OrderService {

    private final PaymentStrategy paymentStrategy;
    private final DiscountStrategy discountStrategy;
    private final DeliveryStrategy deliveryStrategy;

    public OrderService(
            PaymentStrategy paymentStrategy,
            DiscountStrategy discountStrategy,
            DeliveryStrategy deliveryStrategy
    ) {
        this.paymentStrategy = paymentStrategy;
        this.discountStrategy = discountStrategy;
        this.deliveryStrategy = deliveryStrategy;
    }

    public void placeOrder(Order order) {

        double foodAmount = order.getFoodAmount();
        double distance = order.getDistance();

        double discount = discountStrategy.calculateDiscount(foodAmount);
        double deliveryFee = deliveryStrategy.calculateDeliveryFee(distance);
        double finalAmount = foodAmount - discount + deliveryFee;

        System.out.println("Food amount: ₹" + foodAmount);
        System.out.println("Discount: ₹" + discount);
        System.out.println("Delivery fee: ₹" + deliveryFee);
        System.out.println("Final amount: ₹" + finalAmount);

        paymentStrategy.pay(finalAmount);
    }
}