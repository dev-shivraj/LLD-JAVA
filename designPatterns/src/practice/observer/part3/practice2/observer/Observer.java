package practice.observer.part3.practice2.observer;

import practice.observer.part3.practice2.event.OrderEvent;

public interface Observer {

    void update(OrderEvent event);
}