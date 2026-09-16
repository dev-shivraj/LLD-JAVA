package practice.strategy.part2.example5;

import practice.strategy.part2.example5.service.CheckoutService;
import practice.strategy.part2.example5.strategy.discount.DiscountStrategy;
import practice.strategy.part2.example5.strategy.discount.PremiumDiscountStrategy;
import practice.strategy.part2.example5.strategy.payment.PaymentStrategy;
import practice.strategy.part2.example5.strategy.payment.UpiPaymentStrategy;
import practice.strategy.part2.example5.strategy.shipping.ExpressShippingStrategy;
import practice.strategy.part2.example5.strategy.shipping.ShippingStrategy;

public class Client {

    public static void main(String[] args) {

        PaymentStrategy paymentStrategy = new UpiPaymentStrategy();
        ShippingStrategy shippingStrategy = new ExpressShippingStrategy();
        DiscountStrategy discountStrategy = new PremiumDiscountStrategy();

        CheckoutService checkoutService = new CheckoutService(paymentStrategy, shippingStrategy, discountStrategy);
        checkoutService.checkout(2000);
    }
}