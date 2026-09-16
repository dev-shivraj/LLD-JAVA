package practice.observer.part4.practice2.subject;

import practice.observer.part4.practice2.event.StockEvent;
import practice.observer.part4.practice2.observer.Observer;

import java.util.LinkedHashSet;
import java.util.Set;

public class Stock {

    private String symbol;
    private double price;

    private Set<Observer> observers = new LinkedHashSet<>();

    public Stock(String symbol, double price) {
        this.symbol = symbol;
        this.price = price;
    }

    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }

    public void setPrice(double newPrice) {

        double oldPrice = price;

        price = newPrice;

        StockEvent event = new StockEvent(symbol, oldPrice, newPrice);

        notifyObservers(event);
    }

    private void notifyObservers(StockEvent event) {
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