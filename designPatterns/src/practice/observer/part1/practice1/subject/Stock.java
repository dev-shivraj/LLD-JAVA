package practice.observer.part1.practice1.subject;

import practice.observer.part1.practice1.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class Stock {

    private List<Observer> observers = new ArrayList<>();
    private double price;

    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }

    public void setPrice(double price) {
        this.price = price;
        notifyObservers();
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(price);
        }
    }
}