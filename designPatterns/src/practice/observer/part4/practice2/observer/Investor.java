package practice.observer.part4.practice2.observer;

import practice.observer.part4.practice2.event.StockEvent;

public class Investor implements Observer {

    private String name;

    public Investor(String name) {
        this.name = name;
    }

    @Override
    public void update(StockEvent event) {
        System.out.println(name + " received " + event.getSymbol() + " price: " + event.getNewPrice());
    }
}