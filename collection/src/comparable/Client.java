package comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        Item item1 = new Item("1", "Bat", 10, 500.0);
        Item item2 = new Item("2", "Ball", 5, 100.0);
        Item item3 = new Item("3", "Glove", 20, 2000.5);
        Item item4 = new Item("4", "Helmet", 15, 500.0);
        Item item5 = new Item("5", "Shoes", 8, 3000.0);
        Item item6 = new Item("6", "Shoes", 8, 3000.0);
        Item item7 = new Item("7", "Shoes", 7, 3000.0);

        List<Item> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);
        items.add(item5);
        items.add(item6);
        items.add(item7);
        // without implementing Comparable interface, we cannot sort the items list
        // so we need to implement Comparable interface in Item class and override compareTo method
        Collections.sort(items);

        for (Item item : items) {
            // print items based on toString method of Item class
            System.out.println(item);
        }

    }
}
