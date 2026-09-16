package practice.observer.part4.example1.observer;

import practice.observer.part4.example1.strategy.NotificationStrategy;
import practice.observer.part4.example1.event.OrderEvent;

public class NotificationObserver implements Observer {

    private NotificationStrategy strategy;

    public NotificationObserver(NotificationStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void update(OrderEvent event) {
        String message = "Order " + event.getOrderId() + " is " + event.getType();
        strategy.send(event.getCustomerId(), message);
    }
}