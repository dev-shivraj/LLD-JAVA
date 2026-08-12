package inventoryManagementSystem;

public class ClientRecentlyViewed {
    public static void main(String[] args) {
        RecentlyViewedItems items = new RecentlyViewedItems();
        Item item1 = new Item("1", "Apple", 10.5, 5);
        Item item2 = new Item("2", "Banana", 2.3, 10);
        Item item3 = new Item("3", "Orange", 8.7, 8);
        Item item4 = new Item("4", "Grapes", 4.0, 12);
        Item item5 = new Item("5", "Mango", 15.0, 7);
        Item item6 = new Item("6", "Pineapple", 20.0, 3);
        Item item7 = new Item("7", "Strawberry", 5.0, 15);
        Item item8 = new Item("8", "Blueberry", 6.0, 9);
        Item item9 = new Item("9", "Watermelon", 12.0, 4);

        items.addRecentlyViewedItem(item1);
        items.addRecentlyViewedItem(item2);
        items.addRecentlyViewedItem(item3);
        items.addRecentlyViewedItem(item4);
        items.addRecentlyViewedItem(item5);
        items.addRecentlyViewedItem(item6);
        items.addRecentlyViewedItem(item7);
        items.addRecentlyViewedItem(item8);
        items.addRecentlyViewedItem(item9);

        System.out.println("-------------------------- Recently Viewed Items --------------------------");

        System.out.println("Items in the recently viewed list:");
        for (Item item : items.getRecentlyViewedItems()) {
            System.out.println(item);
        }
        System.out.println("---------------------------------------------------------------------------");


        System.out.println("-------------------------- adding more than 10 items in the list ----------");

        Item item10 = new Item("10", "Kiwi", 7.0, 6);
        Item item11 = new Item("11", "Papaya", 9.0, 5);
        Item item12 = new Item("12", "Peach", 8.0, 4);

        items.addRecentlyViewedItem(item10);
        items.addRecentlyViewedItem(item11);
        items.addRecentlyViewedItem(item12);

        System.out.println("Items in the recently viewed list after adding more than 10 items:");
        for (Item item : items.getRecentlyViewedItems()) {
            System.out.println(item);
        }
        System.out.println("---------------------------------------------------------------------------");
    }
}
