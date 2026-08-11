package comparable;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        Item item1 = new Item("1", "Bat", 10, 500.0);
        Item item2 = new Item("2", "Ball", 5, 100.0);
        Item item3 = new Item("3", "Glove", 20, 2000.5);

        List<Item> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        items.add(item3);

    }
}
