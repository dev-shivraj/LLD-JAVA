package class_and_objects;

public class Driver {

    // member variables (attributes) of the Driver class :
    int driverId;
    String name;
    double rating;
    boolean isOnline;

    // state of an object : the values of its attributes at a given point in time


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
