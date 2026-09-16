package practice.observer.part3.example1.observer;

import practice.observer.part3.example1.event.OrderEvent;

public class EmailNotification implements Observer {

    @Override
    public void update(OrderEvent event) {
        System.out.println("Email: Order " + event.getOrderId() + " is " + event.getStatus());
    }
}