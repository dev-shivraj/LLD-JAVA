package practice.observer.part2.practice1.observer;

public class InventoryService implements Observer {

    @Override
    public void update(String event) {
        System.out.println("Inventory Service received: " + event);
    }
}