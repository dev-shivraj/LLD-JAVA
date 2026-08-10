package class_and_objects;

public class Driver {
    int driverId;
    String name;
    double rating;
    boolean isOnline;

    public void acceptRide(String rideId) {
        System.out.println("Driver " + name + " has accepted the ride with ID: " + rideId);
    }

    public void changeStatus() {
        isOnline = !isOnline;
        String status = isOnline ? "online" : "offline";
        System.out.println("Driver " + name + " is now " + status);
    }
}
