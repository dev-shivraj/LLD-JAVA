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

    /*
        this is to think that even if we keep member as private and keeping the getter setters, we can still access the data in client code
        only thing is that we have validations now
        but what if there is no validations
        this can still be directly accessible and anyone can access it through the client code

        the answer to this is that yes, any client can change it if we want
        but if we want it completely private and don't want any client to access it, we can not expose the setter method
        so this way we can completely protect our data/
        depending on our use case we can control it

        so,
        encapsulation provide us complete control of the data along with the validation that we can apply on the data
     */
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
