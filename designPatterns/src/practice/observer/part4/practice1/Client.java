package practice.observer.part4.practice1;

import practice.observer.part4.practice1.observer.AnalyticsObserver;
import practice.observer.part4.practice1.observer.InventoryObserver;
import practice.observer.part4.practice1.observer.NotificationObserver;
import practice.observer.part4.practice1.service.Order;
import practice.observer.part4.practice1.strategy.EmailStrategy;
import practice.observer.part4.practice1.strategy.PushStrategy;
import practice.observer.part4.practice1.strategy.SmsStrategy;
import practice.observer.part4.practice1.subject.EventPublisher;

public class Client {

    public static void main(String[] args) {

        EventPublisher publisher = new EventPublisher();

        InventoryObserver inventory = new InventoryObserver();
        AnalyticsObserver analytics = new AnalyticsObserver();
        NotificationObserver notification = new NotificationObserver(new EmailStrategy());

        publisher.subscribe(inventory);
        publisher.subscribe(analytics);
        publisher.subscribe(notification);

        Order order = new Order("ORD-101", "CUST-501", publisher);
        order.place();
        System.out.println();

        notification.setStrategy(new SmsStrategy());
        order.ship();
        System.out.println();

        notification.setStrategy(new PushStrategy());
        order.cancel();
        System.out.println();

        publisher.unsubscribe(analytics);
        order.place();
    }
}