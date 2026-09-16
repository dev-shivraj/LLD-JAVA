package practice.observer.part2.practice1.subject;

import practice.observer.part2.practice1.observer.Observer;

import java.util.HashSet;
import java.util.Set;

public class Order implements Subject {

    private Set<Observer> observers = new HashSet<>();

    @Override
    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String event) {
        for (Observer observer : observers) {
            observer.update(event);
        }
    }

    public void place() {
        System.out.println("Order placed");
        notifyObservers("ORDER_PLACED");
    }

    public void cancel() {
        System.out.println("Order cancelled");
        notifyObservers("ORDER_CANCELLED");
    }
}