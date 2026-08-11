package toString;

public class Driver {

    int driverId;
    String name;
    double rating;
    boolean isOnline;

    public Driver() {
    }

    public Driver(int driverId, String name, double rating, boolean isOnline) {
        this.driverId = driverId;
        this.name = name;
        this.rating = rating;
        this.isOnline = isOnline;
    }

    /**
     * toString method is overridden to provide a string representation of the Driver object.
     * It returns a string that includes the class name and the values of its fields in a readable format.
     * This is useful for debugging and logging purposes, as it allows developers to easily see the
     * state of a Driver object when it is printed or logged.
     */
    @Override
    public String toString() {

        // returns hello for every object of Driver class
        // return "hello";

        return "Driver{" +
                "driverId=" + driverId +
                ", name='" + name + '\'' +
                ", rating=" + rating +
                ", isOnline=" + isOnline +
                '}';
    }
}
