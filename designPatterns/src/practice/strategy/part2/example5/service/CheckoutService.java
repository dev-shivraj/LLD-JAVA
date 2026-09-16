package practice.strategy.part2.example5.service;

import practice.strategy.part2.example5.strategy.discount.DiscountStrategy;
import practice.strategy.part2.example5.strategy.payment.PaymentStrategy;
import practice.strategy.part2.example5.strategy.shipping.ShippingStrategy;

public class CheckoutService {

    private final PaymentStrategy paymentStrategy;
    private final ShippingStrategy shippingStrategy;
    private final DiscountStrategy discountStrategy;

    public CheckoutService(
            PaymentStrategy paymentStrategy,
            ShippingStrategy shippingStrategy,
            DiscountStrategy discountStrategy
    ) {
        this.paymentStrategy = paymentStrategy;
        this.shippingStrategy = shippingStrategy;
        this.discountStrategy = discountStrategy;
    }

    public void checkout(double productPrice) {

        double discount = discountStrategy.calculateDiscount(productPrice);
        double shippingCost = shippingStrategy.calculateCost();
        double finalAmount = productPrice - discount + shippingCost;

        System.out.println("Product price: ₹" + productPrice);
        System.out.println("Discount: ₹" + discount);
        System.out.println("Shipping: ₹" + shippingCost);
        System.out.println("Final amount: ₹" + finalAmount);

        paymentStrategy.pay(finalAmount);
    }
}