package encapsulation;

public class Driver {

    /*
        because of any client can modifiy the data members directly
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

    public void setRating(double rating) {
        this.rating = rating;
    }
}
