package practice.observer.part2.practice1;

import practice.observer.part2.practice1.observer.AnalyticsService;
import practice.observer.part2.practice1.observer.EmailService;
import practice.observer.part2.practice1.observer.InventoryService;
import practice.observer.part2.practice1.observer.Observer;
import practice.observer.part2.practice1.subject.Order;

public class Client {

    public static void main(String[] args) {

        Order order = new Order();

        Observer email = new EmailService();
        Observer inventory = new InventoryService();
        Observer analytics = new AnalyticsService();

        order.subscribe(email);
        order.subscribe(inventory);
        order.subscribe(analytics);

        // Duplicate registration is ignored by Set.
        order.subscribe(email);
        order.place();
        System.out.println();

        order.unsubscribe(analytics);
        order.cancel();
    }
}