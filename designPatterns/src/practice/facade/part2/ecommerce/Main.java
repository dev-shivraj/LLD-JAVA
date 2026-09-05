package practice.facade.part2.ecommerce;

import practice.facade.part2.ecommerce.facade.CheckoutFacade;
import practice.facade.part2.ecommerce.record.CheckoutRequest;
import practice.facade.part2.ecommerce.record.CheckoutResult;
import practice.facade.part2.ecommerce.services.*;

public class Main {
    public static void main(String[] args) {
        CartService cartService = new CartService();
        PricingService pricingService = new PricingService();
        InventoryService inventoryService = new InventoryService();
        PaymentService paymentService = new PaymentService();
        OrderService orderService = new OrderService();
        NotificationService notificationService = new NotificationService();

        CheckoutFacade checkoutFacade = new CheckoutFacade(cartService, pricingService, inventoryService, paymentService, orderService, notificationService);
        CheckoutRequest request = new CheckoutRequest("USER-101", "PAY-123");

        // failure scenario
        // request = new CheckoutRequest("USER-101", "FAIL");

        CheckoutResult result = checkoutFacade.checkout(request);
        System.out.println("Checkout completed: " + result);
    }
}