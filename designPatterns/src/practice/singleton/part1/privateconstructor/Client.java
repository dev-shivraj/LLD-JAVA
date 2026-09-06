package practice.singleton.part1.privateconstructor;

public class Client {

    public static void main(String[] args) {
        DatabaseConnection connection1 = DatabaseConnection.getInstance();
        DatabaseConnection connection2 = DatabaseConnection.getInstance();
        DatabaseConnection connection3 = DatabaseConnection.getInstance();

        System.out.println(connection1);
        System.out.println(connection2);
        System.out.println(connection3);


        // check if all the instances are same
        System.out.println(connection1 == connection2);
        System.out.println(connection2 == connection3);
        System.out.println(connection1 == connection3);
    }
}