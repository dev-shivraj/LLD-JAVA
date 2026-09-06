package practice.singleton.part1.privateconstructor;

public class DatabaseConnection {

    private static DatabaseConnection instance = new DatabaseConnection();

    private DatabaseConnection() {
        System.out.println("DatabaseConnection object created");
    }

    public static DatabaseConnection getInstance() {
        return instance;
    }
}