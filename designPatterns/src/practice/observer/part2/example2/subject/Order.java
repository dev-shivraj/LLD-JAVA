package practice.observer.part2.example2.subject;

import practice.observer.part2.example2.observer.Observer;

import java.util.HashSet;
import java.util.Set;

public class Order {

    private Set<Observer> observers = new HashSet<>();

    private String orderId;
    private String status;

    public Order(String orderId) {
        this.orderId = orderId;
    }

    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }

    public void updateStatus(String status) {
        this.status = status;
        notifyObservers();
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(orderId, status);
        }
    }
}