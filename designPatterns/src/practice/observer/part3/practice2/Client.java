package practice.observer.part3.practice2;

import practice.observer.part3.practice2.event.OrderEvent;
import practice.observer.part3.practice2.observer.AnalyticsObserver;
import practice.observer.part3.practice2.observer.InventoryObserver;
import practice.observer.part3.practice2.observer.NotificationObserver;
import practice.observer.part3.practice2.observer.Observer;
import practice.observer.part3.practice2.strategy.EmailStrategy;
import practice.observer.part3.practice2.subject.OrderEventPublisher;

public class Client {

    public static void main(String[] args) {

        OrderEventPublisher publisher = new OrderEventPublisher();

        Observer inventory =new InventoryObserver();

        Observer analytics =new AnalyticsObserver();

        Observer notification = new NotificationObserver(new EmailStrategy());

        publisher.subscribe(inventory);
        publisher.subscribe(analytics);
        publisher.subscribe(notification);

        OrderEvent event = new OrderEvent("ORD-101", "CUST-501", 2500);

        publisher.publish(event);
    }
}