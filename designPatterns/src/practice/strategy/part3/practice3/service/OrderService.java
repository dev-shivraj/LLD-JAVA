package practice.strategy.part3.practice3.service;

import practice.strategy.part3.practice3.strategy.discount.DiscountStrategy;
import practice.strategy.part3.practice3.strategy.shipping.ShippingStrategy;
import practice.strategy.part3.practice3.strategy.tax.TaxStrategy;

public class OrderService {

    private final DiscountStrategy discountStrategy;
    private final ShippingStrategy shippingStrategy;
    private final TaxStrategy taxStrategy;

    public OrderService(
            DiscountStrategy discountStrategy,
            ShippingStrategy shippingStrategy,
            TaxStrategy taxStrategy
    ) {
        this.discountStrategy = discountStrategy;
        this.shippingStrategy = shippingStrategy;
        this.taxStrategy = taxStrategy;
    }

    public double calculateFinalPrice(double productPrice) {
        double discount = discountStrategy.calculateDiscount(productPrice);
        double priceAfterDiscount = productPrice - discount;

        double shipping = shippingStrategy.calculateShipping(productPrice);
        double tax = taxStrategy.calculateTax(priceAfterDiscount);

        return priceAfterDiscount + shipping + tax;
    }
}