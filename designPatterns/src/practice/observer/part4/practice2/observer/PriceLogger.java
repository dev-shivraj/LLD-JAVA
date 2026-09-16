package practice.observer.part4.practice2.observer;

import practice.observer.part4.practice2.event.StockEvent;

public class PriceLogger implements Observer {
    @Override
    public void update(StockEvent event) {
        System.out.println("Price log: " + event.getSymbol() + " = " + event.getNewPrice());
    }
}