package inventory_management_system.items;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ItemTest {
    public static void main(String[] args) {
        List<Item> items = new ArrayList<>();

        items.add(new Electronics("E101", "Laptop", 75000, 10, 2));
        items.add(new Electronics("E102", "Mobile Phone", 30000, 20, 1));

        items.add(new Clothing("C101", "T-Shirt", 999, 50, "L"));
        items.add(new Clothing("C102", "Jeans", 1999, 30, "32"));

        items.add(new Book("B101", "Clean Code", 1200, 15, "Robert C. Martin"));
        items.add(new Book("B102", "Effective Java", 1500, 10, "Joshua Bloch"));

        System.out.println("Before sorting:");
        for (Item item : items) {
            System.out.println(item);
        }

        Collections.sort(items);

        System.out.println("\nAfter sorting by name:");
        for (Item item : items) {
            System.out.println(item);
        }
    }
}