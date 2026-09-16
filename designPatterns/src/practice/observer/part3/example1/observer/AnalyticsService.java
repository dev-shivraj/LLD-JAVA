package practice.observer.part3.example1.observer;

import practice.observer.part3.example1.event.OrderEvent;

public class AnalyticsService implements Observer {

    @Override
    public void update(OrderEvent event) {
        System.out.println("Analytics: " + event.getOrderId() + " -> " + event.getStatus() + ", amount = " + event.getAmount());
    }
}