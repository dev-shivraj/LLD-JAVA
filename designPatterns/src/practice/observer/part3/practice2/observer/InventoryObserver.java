package practice.observer.part3.practice2.observer;

import practice.observer.part3.practice2.event.OrderEvent;

public class InventoryObserver implements Observer {

    @Override
    public void update(OrderEvent event) {
        System.out.println("Inventory reserved for order " + event.getOrderId());
    }
}