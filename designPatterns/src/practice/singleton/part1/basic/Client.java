package practice.singleton.part1.basic;

public class Client {

    public static void main(String[] args) {
        DatabaseConnection connection1 = new DatabaseConnection();
        DatabaseConnection connection2 = new DatabaseConnection();
        DatabaseConnection connection3 = new DatabaseConnection();
    }
}