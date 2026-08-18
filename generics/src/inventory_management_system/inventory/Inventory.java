package inventory_management_system.inventory;

import inventory_management_system.items.Item;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Inventory<T extends Item> {
    private final Map<String, T> items;

    public Inventory() {
        this.items = new HashMap<>();
    }

    public void addItem(T item) {
        if(item.getQuantity() < 0) {
            throw new IllegalArgumentException(
                    "Item quantity cannot be negative."
            );
        }

        if (items.containsKey(item.getId())) {
            throw new IllegalArgumentException(
                    "Item with ID '" + item.getId() + "' already exists."
            );
        }

        items.put(item.getId(), item);
    }

    public T removeItem(String id) {
        return items.remove(id);
    }

    public T getItem(String id) {
        return items.get(id);
    }

    public Collection<T> getAllItems() {
        return items.values();
    }
}
