package practice.observer.part4.practice2.observer;

import practice.observer.part4.practice2.event.StockEvent;

public class TradingDashboard implements Observer {
    @Override
    public void update(StockEvent event) {
        System.out.println("Dashboard: " + event.getSymbol() + " changed from " + event.getOldPrice() + " to " + event.getNewPrice());
    }
}