package static_keyword;

public class
Client {
    static void main() {
        Driver driver1 = new Driver(101, "John Doe", 4.8, true);
        Driver driver2 = new Driver(102, "Jane Smith", 4.5, false);
        Driver driver3 = new Driver(103, "Mike Johnson", 4.9, true);
        Driver driver4 = new Driver(104, "Emily Davis", 4.7, false);

        /*
            // we can use driver1.totalDrivers or driver2.totalDrivers or driver3.totalDrivers or driver4.totalDrivers to access the static variable
            // but it is not recommended as it can be confusing
            // it is recommended to use the class name to access the static variable
            System.out.println("Total Drivers: " + driver2.totalDrivers);
         */

        // we use the class name to access the static variable
        // this is the recommended way to access static variables
        System.out.println("Total Drivers: " + Driver.totalDrivers);

        System.out.println("DEBUG");

    }
}
