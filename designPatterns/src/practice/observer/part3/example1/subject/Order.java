package practice.observer.part3.example1.subject;

import practice.observer.part3.example1.event.OrderEvent;
import practice.observer.part3.example1.observer.Observer;

import java.util.HashSet;
import java.util.Set;

public class Order {

    private Set<Observer> observers = new HashSet<>();

    private String orderId;
    private String customerId;
    private double amount;

    public Order(String orderId, String customerId, double amount) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.amount = amount;
    }

    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }

    public void updateStatus(String status) {
        OrderEvent event = new OrderEvent(orderId, customerId, amount, status);

        notifyObservers(event);
    }

    private void notifyObservers(OrderEvent event) {
        for (Observer observer : observers) {
            observer.update(event);
        }
    }
}