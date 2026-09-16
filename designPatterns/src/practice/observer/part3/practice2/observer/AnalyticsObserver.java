package practice.observer.part3.practice2.observer;

import practice.observer.part3.practice2.event.OrderEvent;

public class AnalyticsObserver implements Observer {

    @Override
    public void update(OrderEvent event) {
        System.out.println("Analytics recorded order " + event.getOrderId() + ", amount = " + event.getAmount());
    }
}