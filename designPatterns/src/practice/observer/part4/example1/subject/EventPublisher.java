package practice.observer.part4.example1.subject;

import practice.observer.part4.example1.event.OrderEvent;
import practice.observer.part4.example1.observer.Observer;

import java.util.LinkedHashSet;
import java.util.Set;

public class EventPublisher {

    private Set<Observer> observers = new LinkedHashSet<>();

    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }

    public void publish(OrderEvent event) {
        Set<Observer> snapshot = new LinkedHashSet<>(observers);

        for (Observer observer : snapshot) {
            try {
                observer.update(event);
            } catch (Exception exception) {
                System.out.println("Observer failed: " + observer.getClass().getSimpleName());
            }
        }
    }
}