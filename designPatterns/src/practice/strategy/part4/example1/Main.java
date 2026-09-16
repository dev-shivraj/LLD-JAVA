package practice.strategy.part4.example1;

import practice.strategy.part4.example1.component.Order;
import practice.strategy.part4.example1.service.OrderService;
import practice.strategy.part4.example1.strategy.delivery.BikeDelivery;
import practice.strategy.part4.example1.strategy.delivery.DeliveryStrategy;
import practice.strategy.part4.example1.strategy.discount.DiscountStrategy;
import practice.strategy.part4.example1.strategy.discount.PremiumDiscount;
import practice.strategy.part4.example1.strategy.payment.PaymentStrategy;
import practice.strategy.part4.example1.strategy.payment.UpiPayment;

public class Main {

    public static void main(String[] args) {

        Order order = new Order(1000, 5);

        PaymentStrategy payment = new UpiPayment();
        DiscountStrategy discount = new PremiumDiscount();
        DeliveryStrategy delivery = new BikeDelivery();

        OrderService orderService = new OrderService(payment, discount, delivery);
        orderService.placeOrder(order);
    }
}