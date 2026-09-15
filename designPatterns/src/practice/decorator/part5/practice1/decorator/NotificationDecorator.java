package practice.decorator.part5.practice1.decorator;

import practice.decorator.part5.practice1.component.ShippingService;

public class NotificationDecorator extends ShippingServiceDecorator {

    public NotificationDecorator(ShippingService shippingService) {
        super(shippingService);
    }

    @Override
    public void ship(String orderId) {
        shippingService.ship(orderId);
        System.out.println("[NOTIFICATION] Customer notified for " + orderId);
    }
}