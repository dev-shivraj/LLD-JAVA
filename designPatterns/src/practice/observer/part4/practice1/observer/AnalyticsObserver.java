package practice.observer.part4.practice1.observer;

import practice.observer.part4.practice1.event.OrderEvent;

public class AnalyticsObserver implements Observer {
    @Override
    public void update(OrderEvent event) {
        System.out.println("Analytics: " + event.getType() + " -> " + event.getOrderId());
    }
}