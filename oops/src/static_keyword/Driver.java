package static_keyword;

public class Driver {

    int driverId;
    String name;
    double rating;
    boolean isOnline;

    // if we do keep the count of total drivers in this variable
    // then it will not work as it is not shared across all instances of the class.
    // Each instance will have its own copy of totalDrivers
    // and it will not reflect the total number of drivers created.
    int totalDrivers;

    public Driver() {
    }

    public Driver(int driverId, String name, double rating, boolean isOnline) {
        this.driverId = driverId;
        this.name = name;
        this.rating = rating;
        this.isOnline = isOnline;

        this.totalDrivers++;
    }
}
