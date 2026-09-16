package practice.observer.part4.practice1.observer;

import practice.observer.part4.practice1.event.EventType;
import practice.observer.part4.practice1.event.OrderEvent;

public class InventoryObserver implements Observer {
    @Override
    public void update(OrderEvent event) {
        if (event.getType() == EventType.ORDER_PLACED) {
            System.out.println("Inventory reserved: " + event.getOrderId());
        } else if (event.getType() == EventType.ORDER_CANCELLED) {
            System.out.println("Inventory released: " + event.getOrderId());
        }
    }
}