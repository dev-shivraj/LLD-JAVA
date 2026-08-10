package class_and_objects;

public class Client2 {
    static void main() {
        // I want to create a driver object
        // in how many ways I can create a driver object?

        // 1. using default constructor
        Driver driver1 = new Driver();

        // 2. using parameterized constructor
        Driver driver2 = new Driver("John Doe");

        // 3. using parameterized constructor with all attributes
        Driver driver3 = new Driver(101, "John Doe", 4.8, true);

        System.out.println("DEBUG");

        // if we are having n attributes in a class
        // then we can have total of 2 ^ n constructors in that class
        // so we can create the object of that class in 2 ^ n ways
        // either include or exclude each attribute in the constructor

    }
}
