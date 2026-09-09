package practice.fundamentals.classandobjects.example1;

public class Main {
    public static void main(String[] args) {
        Car car1 = new Car();
        car1.brand = "BMW";
        car1.color = "Red";

        Car car2 = new Car();
        car2.brand = "Toyota";
        car2.color = "Blue";

        car1.displayInfo();
        car1.drive();
        System.out.println();

        car2.displayInfo();
        car2.drive();
    }
}
