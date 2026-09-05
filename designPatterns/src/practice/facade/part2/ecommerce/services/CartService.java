package practice.facade.part2.ecommerce.services;

import practice.facade.part2.ecommerce.record.Cart;

import java.util.List;

public class CartService {
    public Cart getCart(String userId) {
        System.out.println("Fetching cart for user: " + userId);

        return new Cart(userId, List.of("Laptop", "Mouse"));
    }
}
