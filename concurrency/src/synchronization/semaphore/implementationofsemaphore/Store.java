package synchronization.semaphore.implementationofsemaphore;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Store {
    private int maxSize;
    private List<Object> items;
    private Lock lock = new ReentrantLock();

    // ======================== methods ==============================
    public void addItem(Object item) {
//        if(items.size() < maxSize) {
        lock.lock();
        items.add(item); // O(1)
        System.out.println("Produced an item. Total items: " + items.size());
        lock.unlock();
//        }
    }

    public void removeItem() {
//        if(items.size() > 0) {
        lock.lock();
        items.remove(items.size() - 1); // O(1)
        System.out.println("Consumed an item. Total items: " + items.size());
        lock.unlock();
//        }
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
