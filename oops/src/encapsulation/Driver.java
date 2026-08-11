package encapsulation;

public class Driver {

    /*
        because of any client can modify the data members directly
        we make the data members private so that they cannot be accessed directly from outside the class.
        so we make the data members private and provide public getter and setter methods to access and modify the data members.
        This way we can control the access to the data members and can add validation or any other logic in the getter and setter methods.
        we can do it by access modifiers.
        we can use private access modifier to make the data members private
        and public access modifier to make the getter and setter methods public.
     */
    private int driverId;
    private String name;
    private double rating;
    private boolean isOnline;

    public Driver() {
    }

    public Driver(int driverId, String name, double rating, boolean isOnline) {
        this.driverId = driverId;
        this.name = name;
        this.rating = rating;
        this.isOnline = isOnline;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        // this.rating = rating;

        /*
            by just exposing the setter and making the data members private we can not control the access to the data members
            client can still modify the data members directly by calling the setter method.

            so we can add validation or any other logic in the setter method to control the access to the data members.
            for example, we can add validation to check if the rating is between 0 and 5.
         */

        if(rating < 0 || rating > 5) {
            throw new IllegalArgumentException("Rating should be between 0 and 5");
        } else {
            this.rating = rating;
        }
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }
}
