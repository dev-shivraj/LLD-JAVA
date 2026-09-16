package practice.strategy.part3.practice1.service;

import practice.strategy.part3.practice1.strategy.ShippingStrategy;

public class ShippingService {

    private final ShippingStrategy shippingStrategy;

    public ShippingService(
            ShippingStrategy shippingStrategy
    ) {
        this.shippingStrategy = shippingStrategy;
    }

    public double calculateShipping(double weight) {
        return shippingStrategy.calculateShipping(weight);
    }
}