package this_keyword;

public class Driver {

    // member variables (attributes) of the Driver class :
    int driverId;
    String name;
    double rating;
    boolean isOnline;

    public Driver() {
    }

    /*
        public Driver(int id, String n, double r, boolean online) {
            driverId = id;
            name = n;
            rating = r;
            isOnline = online;
        }
     */

    /*
        // scenario: Using the same parameter names as the member variables
        // ambiguity arises between the member variables and the parameters
        // so member variables are shadowed by the parameters
        // so member variable will not be initialized with the values passed to the constructor
        public Driver(int driverId, String name, double rating, boolean isOnline) {
            driverId = driverId;
            name = name;
            rating = rating;
            isOnline = isOnline;
        }
    */

    // resolve the ambiguity using the 'this' keyword to refer to the member variables of the class
    // 'this' keyword is used to refer to the current object of the class : calling object
    // here we write this.driverId, similar to driver.driverId in client class
    // so we can now interpret 'this' keyword as driver : which is calling object of the class
    public Driver(int driverId, String name, double rating, boolean isOnline) {
        this.driverId = driverId;
        this.name = name;
        this.rating = rating;
        this.isOnline = isOnline;
    }
}
