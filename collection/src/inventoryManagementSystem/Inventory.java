package inventoryManagementSystem;

import java.util.Collection;
import java.util.HashMap;

public class Inventory<T extends Item> {
    private HashMap<String, T> items;

    public Inventory() {
        items = new HashMap<>();
    }

    public void addItem(T item) {
        if(item.getQuantity() <= 0) {
            throw new IllegalArgumentException("Item quantity must be greater than zero.");
        }
        if(items.containsKey(item.getId())) {
            throw new IllegalArgumentException("Item with ID " + item.getId() + " already exists in the inventory.");
        }
        items.put(item.getId(), item);
    }

    public void removeItem(String id) {
        items.remove(id);
    }

    public T getItem(String id) {
        return items.get(id);
    }

    public Collection<T> getAllItems() {
        return items.values();
    }

}
