package practice.observer.part2.example2;

import practice.observer.part2.example2.observer.AnalyticsService;
import practice.observer.part2.example2.observer.EmailNotification;
import practice.observer.part2.example2.observer.Observer;
import practice.observer.part2.example2.observer.SmsNotification;
import practice.observer.part2.example2.subject.Order;

public class Client {

    public static void main(String[] args) {

        Order order = new Order("ORD-101");

        Observer email = new EmailNotification();
        Observer sms = new SmsNotification();
        Observer analytics = new AnalyticsService();

        order.subscribe(email);
        order.subscribe(sms);
        order.subscribe(analytics);

        order.updateStatus("PLACED");
        System.out.println();

        order.updateStatus("SHIPPED");
        System.out.println();

        order.unsubscribe(sms);
        order.updateStatus("DELIVERED");
    }
}