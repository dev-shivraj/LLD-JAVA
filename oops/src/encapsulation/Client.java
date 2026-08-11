package encapsulation;

public class Client {
    public static void main(String[] args) {
        Driver driver = new Driver(1, "John Doe", 4.5, true);

        /*
            Direct access to the rating field
            This is not recommended as any client can modify the data member without any validation or control.
            driver.rating = 4.8;
         */

        // This is recommended as client can now only modify the rating field through the setter method
        // this way we can't directly modify the rating field
        driver.setRating(4.8);

        /*
            This will throw an exception because of the validation in the setter method
            rating should be between 0 and 5
            through the validation in the setter method we can control the access to the data members and can add validation or any other logic in the getter and setter methods.
            so making data members private and providing public getter and setter methods along with validation, we can control the access to the data members and can add validation or any other logic in the getter and setter methods.
        */
        driver.setRating(6.0);

    }
}
