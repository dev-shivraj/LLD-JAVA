package class_and_objects;

public class Client {
    static void main() {
        // here driver1 stores the reference(address) of the Driver class
        // object created in the heap memory : initiated with new keyword
        // driver1 is a reference variable of type Driver
        // here "new" keyword allocates the heap memory
        // and Driver() is the constructor of the Driver class which initializes the object
        // Driver() is a function : special function which is used to initialize the object of the class
        // also known as constructor of the class : used to initialize the object of the class
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

        System.out.println("***********************************************************");
        System.out.println("DEBUG");

        // Now, we will initialize the attributes of the driver1 object with some values.
        driver1.driverId = 101;
        driver1.name = "John Doe";
        driver1.rating = 4.8;
        driver1.isOnline = true;

        driver1.acceptRide("RIDE123");
        System.out.println("DEBUG");


        System.out.println("============================");
        System.out.println(driver1.name);

        // hexadecimal address of the driver1 object in the heap memory
        System.out.println(driver1);
        System.out.println("============================");

        // driver1 reference is now pointing to null
        // the object is detached and eligible for garbage collection
//        driver1 = null;
        System.out.println("DEBUG");


        System.out.println("***********************************************************");

        System.out.println("============================");
        // driver2 is now pointing to the same object as driver1
        Driver driver2 = driver1;
        System.out.println("Driver1 name: " + driver1.name);
        System.out.println("Driver2 name: " + driver2.name);
        System.out.println("DEBUG");
        System.out.println("============================");

        System.out.println("============================");
        driver2.changeStatus();
        System.out.println("Driver1 isOnline: " + driver1.isOnline);
        System.out.println("Driver2 isOnline: " + driver2.isOnline);
        System.out.println("DEBUG");
        System.out.println("============================");

        System.out.println("***********************************************************");

        System.out.println("============================");
        // driver3 is a new reference variable of type Driver
        // pointing to a new object created in the heap memory.
        Driver driver3 = new Driver();

        driver3.driverId = 101;
        driver3.name = "Jane Doe";
        driver3.rating = 4.8;
        driver3.isOnline = true;

        System.out.println("Driver1 name: " + driver1.name);
        System.out.println("Driver2 name: " + driver2.name);
        System.out.println("Driver3 name: " + driver3.name);

        System.out.println("DEBUG");
        System.out.println("============================");

        System.out.println("============================");
        driver1.rating = 3.8;
        System.out.println("Driver1 rating: " + driver1.rating);
        System.out.println("Driver2 rating: " + driver2.rating);
        System.out.println("Driver3 rating: " + driver3.rating);
        System.out.println("DEBUG");
        System.out.println("============================");

        System.out.println("***********************************************************");
        System.out.println("============================");
        String str1 = "Hello";
        String str2 = "Hello";
        String str3 = new String("Hello");

        System.out.println("str1 == str2: " + (str1 == str2)); // true, both refer to the same string literal in the string pool
        System.out.println("str1 == str3: " + (str1 == str3)); // false, str3 refers to a new string object in the heap memory
        System.out.println("str1.equals(str3): " + str1.equals(str3)); // true, both have the same content
        System.out.println("============================");

        System.out.println("***********************************************************");
        System.out.println("============================");
        // use parameterized constructor to create a new object of the Driver class
        Driver driver4 = new Driver(102, "Alice Smith", 4.9, true);
        System.out.println("Driver4 name: " + driver4.name);
        System.out.println("DEBUG");
        System.out.println("============================");

        System.out.println("***********************************************************");
    }
}
