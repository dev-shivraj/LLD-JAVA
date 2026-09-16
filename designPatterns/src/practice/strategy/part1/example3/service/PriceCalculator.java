package practice.strategy.part1.example3.service;

import practice.strategy.part1.example3.strategy.DiscountStrategy;

public class PriceCalculator {

    private final DiscountStrategy discountStrategy;

    public PriceCalculator(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public double calculateFinalPrice(double price) {
        double discount = discountStrategy.calculateDiscount(price);

        return price - discount;
    }
}