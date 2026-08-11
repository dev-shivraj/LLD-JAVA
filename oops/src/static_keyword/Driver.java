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
    // static variables are shared across all instances of the class
    // and it will reflect the total number of drivers created.
    // static variables are also called class variables
    // because they belong to the class rather than any specific instance
    static int totalDrivers;


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
