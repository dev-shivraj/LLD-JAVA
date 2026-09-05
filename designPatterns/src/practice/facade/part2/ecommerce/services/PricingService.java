package practice.facade.part2.ecommerce.services;

import practice.facade.part2.ecommerce.record.Cart;

public class PricingService {
    public double calculatePrice(Cart cart) {
        System.out.println("Calculating price...");

        return 75000;
    }
}
