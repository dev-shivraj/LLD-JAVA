package practice.decorator.part5.practice3;

import practice.decorator.part5.practice3.component.BasicRestaurantOrderService;
import practice.decorator.part5.practice3.component.Order;
import practice.decorator.part5.practice3.component.RestaurantOrderService;
import practice.decorator.part5.practice3.decorator.DiscountDecorator;
import practice.decorator.part5.practice3.decorator.LoggingDecorator;
import practice.decorator.part5.practice3.decorator.NotificationDecorator;
import practice.decorator.part5.practice3.decorator.ValidationDecorator;

public class Client {

    public static void main(String[] args) {
        RestaurantOrderService service = new BasicRestaurantOrderService();

        service = new NotificationDecorator(service);
        service = new DiscountDecorator(service);
        service = new ValidationDecorator(service);
        service = new LoggingDecorator(service);

        Order order = new Order("FOOD-101", 1000);

        service.placeOrder(order);
    }
}