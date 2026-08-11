package static_keyword;

public class Driver {

    int driverId;
    String name;
    double rating;
    boolean isOnline;

    /*
        // if we do keep the count of total drivers in this variable
        // then it will not work as it is not shared across all instances of the class.
        // Each instance will have its own copy of totalDrivers
        // and it will not reflect the total number of drivers created.
        int totalDrivers;
    */

    // static variable to keep track of total drivers
    // static variables are shared across all instances of the class,
    // and it will reflect the total number of drivers created.
    // static variables are also called class variables
    // because they belong to the class rather than any specific instance
    static int totalDrivers;

    // ==========   instance block  ==========
    // static block is executed only once when the class is loaded into memory
    // it is used to initialize static variables or perform any other static initialization
    // it is executed before the constructor and before any instance of the class is created
    // it is executed only once when the class is loaded into memory
    // we can use only static variables and static methods in a static block
    // we can not access instance variables or instance methods in a static block as they do not belong to any specific instance and they are not yet created when the static block is executed
    // it is recommended to use static block for static initialization only
    // we can have multiple static blocks in a class and they will be executed in the order they are defined in the class
    static {
        System.out.println("------------------------------------------------");
        System.out.println("Static block executed");
        System.out.println("Static block is executed only once when the class is loaded into memory");
        totalDrivers = 0;
        System.out.println("------------------------------------------------");
    }

    static {
        System.out.println("------------------------------------------------");
        System.out.println("Another static block executed");
        System.out.println("------------------------------------------------");
    }
    /*
        we can also have static blocks in interfaces and they will be executed when the interface is loaded into memory
        we can also have static blocks in abstract classes and they will be executed when the abstract class is loaded into memory
        we can also have static blocks in enums and they will be executed when the enum is loaded into memory
        we can also have static blocks in inner classes and they will be executed when the inner class is loaded into memory
        we can also have static blocks in anonymous classes and they will be executed when the anonymous class is loaded into memory
        we can also have static blocks in local classes and they will be executed when the local class is loaded into memory
    */

    // ==========   static methods  ==========
    // static methods can only access static variables and other static methods
    // they cannot access instance variables or instance methods
    // because they do not belong to any specific instance
    // it is recommended to use static methods for utility functions that do not require any instance variables or methods
    // static methods can be called using the class name or using an instance(object) of the class
    // but it is recommended to use the class name to call static methods
    public static void displayTotalDrivers() {
        System.out.println("Total Drivers: " + totalDrivers);
    }


    public Driver() {
    }

    public Driver(int driverId, String name, double rating, boolean isOnline) {
        this.driverId = driverId;
        this.name = name;
        this.rating = rating;
        this.isOnline = isOnline;

        /*
            // we can use 'this' keyword as well to refer to the static variable
            // but it is not recommended as it can be confusing
            this.totalDrivers++;
         */


        /*
            // we use the class name to refer to the static variable
            // this is the recommended way to refer to static variables
            Driver.totalDrivers++;
         */

        // or if we are in the same class we can use the variable name directly
        // this is also the recommended way to refer to static variables
         totalDrivers++;
    }
}
