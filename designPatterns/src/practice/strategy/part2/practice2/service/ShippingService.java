package practice.strategy.part2.practice2.service;

import practice.strategy.part2.practice2.strategy.ShippingStrategy;

public class ShippingService {

    private final ShippingStrategy shippingStrategy;

    public ShippingService(ShippingStrategy shippingStrategy) {
        this.shippingStrategy = shippingStrategy;
    }

    public double calculateShippingCost() {
        return shippingStrategy.calculateCost();
    }
}