package practice.observer.part3.example1;

import practice.observer.part3.example1.observer.AnalyticsService;
import practice.observer.part3.example1.observer.EmailNotification;
import practice.observer.part3.example1.observer.InventoryService;
import practice.observer.part3.example1.subject.Order;

public class Client {

    public static void main(String[] args) {

        Order order = new Order("ORD-101", "CUST-501", 2500);

        order.subscribe(new EmailNotification());
        order.subscribe(new InventoryService());
        order.subscribe(new AnalyticsService());

        order.updateStatus("PLACED");
        System.out.println();
        order.updateStatus("SHIPPED");
    }
}