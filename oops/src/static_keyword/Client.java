package static_keyword;

public class
Client {
    static void main() {
        Driver driver1 = new Driver(101, "John Doe", 4.8, true);
        Driver driver2 = new Driver(102, "Jane Smith", 4.5, false);
        Driver driver3 = new Driver(103, "Mike Johnson", 4.9, true);
        Driver driver4 = new Driver(104, "Emily Davis", 4.7, false);

        System.out.println("Total Drivers: " + driver2.totalDrivers);
        System.out.println("DEBUG");

    }
}
