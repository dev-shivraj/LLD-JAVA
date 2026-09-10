package practice.fundamentals.parameterizedconstructors.example3;

public class Main {

    public static void main(String[] args) {

        Car car1 = new Car("BMW", "Black", 120);
        Car car2 = new Car("Audi", "White", 100);

        System.out.println("Car 1:");
        car1.displayInfo();

        System.out.println();

        System.out.println("Car 2:");
        car2.displayInfo();
    }
}