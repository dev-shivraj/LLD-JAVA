package practice.decorator.part5.practice1;

import practice.decorator.part5.practice1.component.BasicShippingService;
import practice.decorator.part5.practice1.component.ShippingService;
import practice.decorator.part5.practice1.decorator.LoggingDecorator;
import practice.decorator.part5.practice1.decorator.NotificationDecorator;
import practice.decorator.part5.practice1.decorator.TrackingDecorator;

public class Client {

    public static void main(String[] args) {
        ShippingService shippingService = new BasicShippingService();

        shippingService = new NotificationDecorator(shippingService);
        shippingService = new TrackingDecorator(shippingService);
        shippingService = new LoggingDecorator(shippingService);

        shippingService.ship("ORD-500");
    }
}