package practice.singleton.part2.examples.databasemanager;

public class DatabaseManager {
    private static volatile DatabaseManager instance;

    private DatabaseManager() {
    }

    public static DatabaseManager getInstance() {
        if (instance == null) {
            synchronized (DatabaseManager.class) {
                if (instance == null) {
                    instance = new DatabaseManager();
                }
            }
        }

        return instance;
    }

    public void connect() {
        System.out.println("Database connected");
    }
}