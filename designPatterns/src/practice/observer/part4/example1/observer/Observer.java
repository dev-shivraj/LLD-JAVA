package practice.observer.part4.example1.observer;

import practice.observer.part4.example1.event.OrderEvent;

public interface Observer {

    void update(OrderEvent event);
}