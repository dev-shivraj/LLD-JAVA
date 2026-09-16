package practice.strategy.part3.practice3;

import practice.strategy.part3.practice3.service.OrderService;
import practice.strategy.part3.practice3.strategy.discount.DiscountStrategy;
import practice.strategy.part3.practice3.strategy.discount.PremiumDiscount;
import practice.strategy.part3.practice3.strategy.shipping.ShippingStrategy;
import practice.strategy.part3.practice3.strategy.shipping.StandardShipping;
import practice.strategy.part3.practice3.strategy.tax.GstTax;
import practice.strategy.part3.practice3.strategy.tax.TaxStrategy;

public class Main {

    public static void main(String[] args) {

        DiscountStrategy discountStrategy = new PremiumDiscount();
        ShippingStrategy shippingStrategy = new StandardShipping();
        TaxStrategy taxStrategy = new GstTax();

        OrderService orderService = new OrderService(discountStrategy, shippingStrategy, taxStrategy);
        double finalPrice = orderService.calculateFinalPrice(1000);
        System.out.println("Final price: " + finalPrice);
    }
}