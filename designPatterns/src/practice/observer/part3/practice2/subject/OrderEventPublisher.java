package practice.observer.part3.practice2.subject;

import practice.observer.part3.practice2.event.OrderEvent;
import practice.observer.part3.practice2.observer.Observer;

import java.util.HashSet;
import java.util.Set;

public class OrderEventPublisher {

    private Set<Observer> observers = new HashSet<>();

    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }

    public void publish(OrderEvent event) {
        for (Observer observer : observers) {
            observer.update(event);
        }
    }
}