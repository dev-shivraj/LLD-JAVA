package practice.decorator.part5.practice1.decorator;

import practice.decorator.part5.practice1.component.ShippingService;

public abstract class ShippingServiceDecorator implements ShippingService {

    protected final ShippingService shippingService;

    protected ShippingServiceDecorator(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    @Override
    public void ship(String orderId) {
        shippingService.ship(orderId);
    }
}