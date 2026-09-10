package practice.fundamentals.constructoroverloading.practice1;

public class Main {

    public static void main(String[] args) {

        Employee employee1 = new Employee();
        Employee employee2 = new Employee("Shivraj");
        Employee employee3 = new Employee("Rahul", 80000, "Engineering");

        System.out.println("Employee 1:");
        employee1.displayInfo();

        System.out.println();

        System.out.println("Employee 2:");
        employee2.displayInfo();

        System.out.println();

        System.out.println("Employee 3:");
        employee3.displayInfo();
    }
}