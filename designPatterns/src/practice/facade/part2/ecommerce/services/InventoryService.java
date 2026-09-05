package practice.facade.part2.ecommerce.services;

import practice.facade.part2.ecommerce.record.Cart;

public class InventoryService {
    public void reserve(Cart cart) {
        System.out.println("Reserving inventory");
    }

    public void release(Cart cart) {
        System.out.println("Releasing inventory...");
    }
}
