package practice.observer.part4.practice2.observer;

import practice.observer.part4.practice2.event.StockEvent;

public interface Observer {

    void update(StockEvent event);
}