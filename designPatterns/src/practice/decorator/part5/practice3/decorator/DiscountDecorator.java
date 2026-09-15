package practice.decorator.part5.practice3.decorator;

import practice.decorator.part5.practice3.component.Order;
import practice.decorator.part5.practice3.component.RestaurantOrderService;

public class DiscountDecorator extends RestaurantOrderServiceDecorator {

    public DiscountDecorator(RestaurantOrderService orderService) {
        super(orderService);
    }

    @Override
    public void placeOrder(Order order) {
        double discountedAmount = order.getAmount() * 0.90;

        System.out.println("[DISCOUNT] 10% discount applied. " + "Final amount ₹" + discountedAmount);

        orderService.placeOrder(new Order(order.getOrderId(), discountedAmount));
    }
}