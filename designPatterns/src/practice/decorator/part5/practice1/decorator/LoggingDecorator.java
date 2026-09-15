package practice.decorator.part5.practice1.decorator;

import practice.decorator.part5.practice1.component.ShippingService;

public class LoggingDecorator extends ShippingServiceDecorator {

    public LoggingDecorator(ShippingService shippingService) {
        super(shippingService);
    }

    @Override
    public void ship(String orderId) {

        System.out.println("[LOG] Shipping started: " + orderId);
        shippingService.ship(orderId);
        System.out.println("[LOG] Shipping completed");
    }
}