package practice.observer.part4.practice1.observer;

import practice.observer.part4.practice1.event.OrderEvent;

public interface Observer {

    void update(OrderEvent event);
}