package practice.fundamentals.instancevariables.example1;

public class Main {

    public static void main(String[] args) {

        Car car1 = new Car();
        Car car2 = new Car();

        car1.brand = "BMW";
        car1.color = "Black";
        car1.speed = 120;

        car2.brand = "Audi";
        car2.color = "White";
        car2.speed = 100;

        System.out.println("Car 1:");
        System.out.println(car1.brand);
        System.out.println(car1.color);
        System.out.println(car1.speed);

        System.out.println();

        System.out.println("Car 2:");
        System.out.println(car2.brand);
        System.out.println(car2.color);
        System.out.println(car2.speed);
    }
}