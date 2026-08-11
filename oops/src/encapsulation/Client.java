package encapsulation;

public class Client {
    static void main() {
        Driver driver = new Driver(1, "John Doe", 4.5, true);

        // Direct access to the rating field
        // This is not recommended as any client can modify the data member without any validation or control.
        driver.rating = 4.8;


    }
}
