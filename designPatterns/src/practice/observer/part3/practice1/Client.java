package practice.observer.part3.practice1;

import practice.observer.part3.practice1.event.Event;
import practice.observer.part3.practice1.event.EventType;
import practice.observer.part3.practice1.observer.AnalyticsObserver;
import practice.observer.part3.practice1.observer.EmailObserver;
import practice.observer.part3.practice1.observer.Observer;
import practice.observer.part3.practice1.subject.EventPublisher;

public class Client {

    public static void main(String[] args) {

        EventPublisher publisher = new EventPublisher();

        Observer email = new EmailObserver();
        Observer analytics = new AnalyticsObserver();

        publisher.subscribe(email);
        publisher.subscribe(analytics);

        publisher.publish(new Event(EventType.USER_REGISTERED, "user-101"));
        System.out.println();

        publisher.publish(new Event(EventType.ORDER_PLACED, "order-501"));
        System.out.println();

        publisher.unsubscribe(email);

        publisher.publish(new Event(EventType.PAYMENT_COMPLETED, "payment-900"));
    }
}