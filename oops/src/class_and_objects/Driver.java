package class_and_objects;

public class Driver {

    // member variables (attributes) of the Driver class :
    int driverId;
    String name;
    double rating;
    boolean isOnline;

    // state of an object : the values of its attributes at a given point in time


    // constructor of the Driver class :
    public Driver() {
        // default constructor : even if we don't define it, Java provides a default constructor
        // java write it likes below ;
        /*
            driverId = 0;
            name = null;
            rating = 0.0;
            isOnline = false;
         */

        // we can also initialize the attributes with some default values in the constructor
        /*
            driverId = 101;
            name = "John Doe";
            rating = 5.0;
            isOnline = false;
         */
    }



    // methods (behaviors) of the Driver class :

    public void acceptRide(String rideId) {
        System.out.println("Driver " + name + " has accepted the ride with ID: " + rideId);
    }

    public void changeStatus() {
        isOnline = !isOnline;
        String status = isOnline ? "online" : "offline";
        System.out.println("Driver " + name + " is now " + status);
    }
}
