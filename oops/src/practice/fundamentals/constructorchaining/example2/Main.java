package practice.fundamentals.constructorchaining.example2;

public class Main {

    public static void main(String[] args) {

        Car car1 = new Car();
        Car car2 = new Car("BMW");
        Car car3 = new Car("Audi", "White");
        Car car4 = new Car("Tesla", "Red", 150);

        System.out.println("Car 1:");
        car1.displayInfo();

        System.out.println();

        System.out.println("Car 2:");
        car2.displayInfo();

        System.out.println();

        System.out.println("Car 3:");
        car3.displayInfo();

        System.out.println();

        System.out.println("Car 4:");
        car4.displayInfo();
    }
}