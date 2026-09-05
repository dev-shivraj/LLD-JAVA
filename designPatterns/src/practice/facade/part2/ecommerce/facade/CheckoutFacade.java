package practice.facade.part2.ecommerce.facade;

import practice.facade.part2.ecommerce.record.Cart;
import practice.facade.part2.ecommerce.record.CheckoutRequest;
import practice.facade.part2.ecommerce.record.CheckoutResult;
import practice.facade.part2.ecommerce.services.*;

public class CheckoutFacade {
    private final CartService cartService;
    private final PricingService pricingService;
    private final InventoryService inventoryService;
    private final PaymentService paymentService;
    private final OrderService orderService;
    private final NotificationService notificationService;

    public CheckoutFacade(CartService cartService, PricingService pricingService, InventoryService inventoryService, PaymentService paymentService, OrderService orderService, NotificationService notificationService) {
        this.cartService = cartService;
        this.pricingService = pricingService;
        this.inventoryService = inventoryService;
        this.paymentService = paymentService;
        this.orderService = orderService;
        this.notificationService = notificationService;
    }

    public CheckoutResult checkout(CheckoutRequest request) {
        Cart cart = cartService.getCart(request.userId());
        double amount = pricingService.calculatePrice(cart);
        inventoryService.reserve(cart);

        try {
            paymentService.pay(request.paymentId(), amount);

            String orderId = orderService.createOrder(cart, amount);
            notificationService.sendConfirmation(request.userId(), orderId);

            return new CheckoutResult(orderId, amount);

        } catch (Exception e) {
            inventoryService.release(cart);
            throw e;
        }
    }
}
