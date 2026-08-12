package inventoryManagementSystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        Item item1 = new Item("1", "Apple", 10.5);
        Item item2 = new Item("2", "Banana", 2.3);
        Item item3 = new Item("3", "Orange", 8.7);
        Item item4 = new Item("4", "Grapes", 4.0);

        List<Item> itemList = new ArrayList<>();
        itemList.add(item1);
        itemList.add(item2);
        itemList.add(item3);
        itemList.add(item4);

        System.out.println("===============================================================");

        System.out.println("Items before sorting:");
        for (Item item : itemList) {
            System.out.println(item);
        }

        System.out.println("===============================================================");


        System.out.println("===============================================================");

        System.out.println("Items after sorting:");
        Collections.sort(itemList);
        for (Item item : itemList) {
            System.out.println(item);
        }

        System.out.println("===============================================================");
    }
}
