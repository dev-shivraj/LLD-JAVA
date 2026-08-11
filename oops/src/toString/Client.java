package toString;

public class
Client {
    public static void main(String[] args) {
        Driver driver = new Driver(1, "John Doe", 4.5, true);

        // will print  : Driver{driverId=1, name='John Doe', rating=4.5, isOnline=true}
        // as the toString method is overridden in the Driver class, it will be called when the object is printed.
        System.out.println(driver);

        Driver driver2 = new Driver(2, "Jane Smith", 4.8, false);
        // will print  : Driver{driverId=2, name='Jane Smith', rating=4.8, isOnline=false}
        System.out.println(driver2);
    }
}
