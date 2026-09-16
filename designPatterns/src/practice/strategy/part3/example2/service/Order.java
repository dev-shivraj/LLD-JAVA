package practice.strategy.part3.example2.service;

import practice.strategy.part3.example2.strategy.DiscountStrategy;

public class Order {

    private final DiscountStrategy discountStrategy;

    public Order(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public double calculateFinalPrice(double amount) {
        double discount = discountStrategy.calculateDiscount(amount);

        return amount - discount;
    }
}