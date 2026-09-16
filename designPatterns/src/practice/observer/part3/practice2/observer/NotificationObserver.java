package practice.observer.part3.practice2.observer;

import practice.observer.part3.practice2.strategy.NotificationStrategy;
import practice.observer.part3.practice2.event.OrderEvent;

public class NotificationObserver implements Observer {

    private NotificationStrategy strategy;

    public NotificationObserver(NotificationStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void update(OrderEvent event) {
        String message = "Order " + event.getOrderId() + " placed successfully";
        strategy.send(message);
    }
}