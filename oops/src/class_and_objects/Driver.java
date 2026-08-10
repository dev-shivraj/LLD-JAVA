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

    // we can also define a parameterized constructor to initialize the attributes with specific values when creating an object of the Driver class
    // if we create a parameterized constructor, we need to explicitly define the default constructor if we want to use it as well.
    // if we don't define the default constructor, Java will not provide it for us if we have defined a parameterized constructor and it will result in a compilation error if we try to create an object of the Driver class using the default constructor.
    // it is because when we define a parameterized constructor, Java assumes that we don't want the default constructor anymore and it will not provide it for us.
    // it's like : either we or java will provide the default constructor but not both. if we define a parameterized constructor, we need to explicitly define the default constructor if we want to use it as well.
    public Driver(int id, String n, double r, boolean online) {
        driverId = id;
        name = n;
        rating = r;
        isOnline = online;
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
