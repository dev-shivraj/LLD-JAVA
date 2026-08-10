package class_and_objects;

public class Client {
    static void main() {
        // here driver1 stores the reference(address) of the Driver class
        // object created in the heap memory : initiated with new keyword
        // driver1 is a reference variable of type Driver
        Driver driver1 = new Driver();

        // right now the state of the driver1 object is not initialized with any values.
        // so it is default state of the object.
        // The attributes of the driver1 object will hold the default values of their respective data types.



        // till this time, the driver1 object is created but not initialized with any values.
        // it will hold the default values of the data types of the attributes of the Driver class.

        // default value of int is 0
        // default value of String is null
        // default value of double is 0.0
        // default value of boolean is false

        System.out.println("DEBUG");

        // Now, we will initialize the attributes of the driver1 object with some values.
        driver1.driverId = 101;
        driver1.name = "John Doe";
        driver1.rating = 4.8;
        driver1.isOnline = true;

        driver1.acceptRide("RIDE123");
        System.out.println("DEBUG");


        System.out.println("====================================");
        System.out.println(driver1.name);

        // hexadecimal address of the driver1 object in the heap memory
        System.out.println(driver1);
        System.out.println("====================================");

        // driver1 reference is now pointing to null
        // the object is detached and eligible for garbage collection
        driver1 = null;
        System.out.println("DEBUG");
    }
}
