package inventory_management_system.inventory;

import inventory_management_system.items.Book;
import inventory_management_system.items.Clothing;
import inventory_management_system.items.Electronics;

public class InventoryTest {
    public static void main(String[] args) {
        Inventory<Electronics> electronicsInventory = new Inventory<>();

        Electronics laptop = new Electronics(
                "E101",
                "Laptop",
                75000,
                10,
                2
        );

        Electronics mobile = new Electronics(
                "E102",
                "Mobile Phone",
                30000,
                20,
                1
        );

        System.out.println("=== ADD ITEMS ===");

        electronicsInventory.addItem(laptop);
        electronicsInventory.addItem(mobile);

        System.out.println("Items added successfully.");

        System.out.println("\n=== GET ITEM ===");

        Electronics item = electronicsInventory.getItem("E101");
        System.out.println(item);

        System.out.println("\n=== GET ALL ITEMS ===");

        for (Electronics electronics : electronicsInventory.getAllItems()) {
            System.out.println(electronics);
        }

        System.out.println("\n=== REMOVE ITEM ===");

        Electronics removed = electronicsInventory.removeItem("E101");
        System.out.println("Removed: " + removed);

        System.out.println("\n=== ITEMS AFTER REMOVAL ===");

        for (Electronics electronics : electronicsInventory.getAllItems()) {
            System.out.println(electronics);
        }

        System.out.println("\n=== GET NON-EXISTING ITEM ===");

        Electronics missing = electronicsInventory.getItem("E999");
        System.out.println("Result: " + missing);

        System.out.println("\n=== REMOVE NON-EXISTING ITEM ===");

        Electronics removedMissing = electronicsInventory.removeItem("E999");
        System.out.println("Result: " + removedMissing);

        System.out.println("\n=== DUPLICATE ID TEST ===");

        try {
            electronicsInventory.addItem(
                    new Electronics(
                            "E102",
                            "Another Mobile",
                            25000,
                            5,
                            1
                    )
            );
        } catch (IllegalArgumentException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        System.out.println("\n=== DIFFERENT INVENTORY TYPES ===");

        Inventory<Book> bookInventory = new Inventory<>();

        bookInventory.addItem(
                new Book(
                        "B101",
                        "Clean Code",
                        1200,
                        10,
                        "Robert C. Martin"
                )
        );

        Inventory<Clothing> clothingInventory = new Inventory<>();

        clothingInventory.addItem(
                new Clothing(
                        "C101",
                        "T-Shirt",
                        999,
                        20,
                        "L"
                )
        );

        System.out.println("\nBook:");
        System.out.println(bookInventory.getItem("B101"));

        System.out.println("\nClothing:");
        System.out.println(clothingInventory.getItem("C101"));
    }
}
