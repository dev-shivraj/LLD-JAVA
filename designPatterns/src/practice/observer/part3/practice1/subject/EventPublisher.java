package practice.observer.part3.practice1.subject;

import practice.observer.part3.practice1.event.Event;
import practice.observer.part3.practice1.observer.Observer;

import java.util.HashSet;

import java.util.Set;

public class EventPublisher {
    private Set<Observer> observers = new HashSet<>();

    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }

    public void publish(Event event) {
        for (Observer observer : observers) {
            observer.update(event);
        }
    }
}