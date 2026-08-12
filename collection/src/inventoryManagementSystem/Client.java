package inventoryManagementSystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        Item item1 = new Item("1", "Apple", 10.5, 5);
        Item item2 = new Item("2", "Banana", 2.3, 10);
        Item item3 = new Item("3", "Orange", 8.7, 8);
        Item item4 = new Item("4", "Grapes", 4.0, 12);

        List<Item> itemList = new ArrayList<>();
        itemList.add(item1);
        itemList.add(item2);
        itemList.add(item3);
        itemList.add(item4);

        System.out.println("===================================================================");

        System.out.println("Items before sorting:");
        for (Item item : itemList) {
            System.out.println(item);
        }

        System.out.println("===================================================================");


        System.out.println("===================================================================");

        System.out.println("Items after sorting:");
        Collections.sort(itemList);
        for (Item item : itemList) {
            System.out.println(item);
        }

        System.out.println("===================================================================");


        System.out.println("======================      Create the Inventory   ================");

        Inventory<Item> inventory = new Inventory<>();

        System.out.println("====================================================================");

        System.out.println("======================      Add items to Inventory   ================");

        inventory.addItem(item1);
        inventory.addItem(item2);
        inventory.addItem(item3);
        inventory.addItem(item4);

        System.out.println("DEBUG");

        System.out.println("====================================================================");


        System.out.println("======================      Remove item from Inventory   ===========");

        inventory.removeItem("2");
        System.out.println("DEBUG");

        System.out.println("====================================================================");


        System.out.println("======================      Get item from Inventory using id  ======");

        Item getInventoryItem1 = inventory.getItem("1");
        System.out.println("Item with id 1: " + getInventoryItem1);
        System.out.println("DEBUG");

        System.out.println("====================================================================");

        System.out.println("======================      Get All items from Inventory   =========");

        List<Item> allItems = new ArrayList<>(inventory.getAllItems());

        for (Item item : allItems) {
            System.out.println(item);
        }

        System.out.println("DEBUG");

        System.out.println("====================================================================");
    }

}
