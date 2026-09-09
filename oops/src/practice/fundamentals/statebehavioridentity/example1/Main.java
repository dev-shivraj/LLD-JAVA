package practice.fundamentals.statebehavioridentity.example1;

public class Main {
    public static void main(String[] args) {
        Car car1 = new Car();
        car1.brand = "BMW";
        car1.color = "Red";
        car1.speed = 50;

        Car car2 = new Car();
        car2.brand = "BMW";
        car2.color = "Red";
        car2.speed = 50;

        System.out.println("Car 1:");
        car1.displayState();
        System.out.println();

        System.out.println("Car 2:");
        car2.displayState();
        System.out.println();

        car1.accelerate();
        System.out.println("After car1 accelerates:");
        System.out.println("Car 1 speed: " + car1.speed);
        System.out.println("Car 2 speed: " + car2.speed);
        System.out.println();

        System.out.println("Are car1 and car2 the same object?");
        System.out.println(car1 == car2);
    }
}
