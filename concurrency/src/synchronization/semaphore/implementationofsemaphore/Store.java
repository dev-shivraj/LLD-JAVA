package synchronization.semaphore.implementationofsemaphore;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private int maxSize;
    private List<Object> items;

    // ======================== methods ==============================
    public synchronized void addItem(Object item) {
        if(items.size() < maxSize) {
            items.add(item);
            System.out.println("Produced an item. Total items: " + items.size());
        }
    }

    public synchronized void removeItem() {
        if(items.size() > 0) {
            items.remove(items.size() - 1);
            System.out.println("Consumed an item. Total items: " + items.size());
        }
    }

    // ===============================================================

    // ========================= constructor =========================
    public Store(int maxSize) {
        this.maxSize = maxSize;
        this.items = new ArrayList<>();
    }
    // ===============================================================

    // ========================= getters and setters =================

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public List<Object> getItems() {
        return items;
    }

    public void setItems(List<Object> items) {
        this.items = items;
    }
    // ===============================================================
}
