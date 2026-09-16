package practice.observer.part4.example1;

import practice.observer.part4.example1.observer.AnalyticsObserver;
import practice.observer.part4.example1.observer.InventoryObserver;
import practice.observer.part4.example1.observer.NotificationObserver;
import practice.observer.part4.example1.observer.Observer;
import practice.observer.part4.example1.service.Order;
import practice.observer.part4.example1.strategy.EmailNotificationStrategy;
import practice.observer.part4.example1.subject.EventPublisher;

public class Client {

    public static void main(String[] args) {

        EventPublisher publisher = new EventPublisher();
        Observer inventory = new InventoryObserver();

        Observer analytics = new AnalyticsObserver();

        Observer notification = new NotificationObserver(new EmailNotificationStrategy());

        publisher.subscribe(inventory);

        publisher.subscribe(analytics);

        publisher.subscribe(notification);

        Order order = new Order("ORD-101", "CUST-501", 2500, publisher);

        order.place();

        System.out.println();

        order.ship();

        System.out.println();

        order.deliver();

        System.out.println();

        order.cancel();

    }

}