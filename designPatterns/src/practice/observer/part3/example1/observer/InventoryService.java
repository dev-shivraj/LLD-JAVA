package practice.observer.part3.example1.observer;

import practice.observer.part3.example1.event.OrderEvent;

public class InventoryService implements Observer {

    @Override
    public void update(OrderEvent event) {
        System.out.println("Inventory updated for order " + event.getOrderId());
    }
}