package practice.decorator.part5.practice1.decorator;

import practice.decorator.part5.practice1.component.ShippingService;

public class TrackingDecorator extends ShippingServiceDecorator {

    public TrackingDecorator(ShippingService shippingService) {
        super(shippingService);
    }

    @Override
    public void ship(String orderId) {
        System.out.println("[TRACKING] Tracking ID generated for " + orderId);
        shippingService.ship(orderId);
    }
}