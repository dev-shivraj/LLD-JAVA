package practice.singleton.part2.examples.databasemanager;

public class Client {
    public static void main(String[] args) {
        DatabaseManager manager1 = DatabaseManager.getInstance();
        DatabaseManager manager2 = DatabaseManager.getInstance();

        manager1.connect();
        System.out.println(manager1 == manager2);
    }
}