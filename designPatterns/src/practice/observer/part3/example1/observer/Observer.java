package practice.observer.part3.example1.observer;

import practice.observer.part3.example1.event.OrderEvent;

public interface Observer {

    void update(OrderEvent event);
}