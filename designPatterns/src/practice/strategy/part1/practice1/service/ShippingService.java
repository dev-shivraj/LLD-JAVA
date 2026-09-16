package practice.strategy.part1.practice1.service;

import practice.strategy.part1.practice1.strategy.ShippingStrategy;

public class ShippingService {

    private final ShippingStrategy shippingStrategy;

    public ShippingService(ShippingStrategy shippingStrategy) {
        this.shippingStrategy = shippingStrategy;
    }

    public double calculateShippingCost() {
        return shippingStrategy.calculateCost();
    }
}