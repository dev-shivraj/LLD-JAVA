package practice.fundamentals.parameterizedconstructors.example2;

public class Main {

    public static void main(String[] args) {

        Employee employee1 =
                new Employee("Shivraj", "EMP101", 80000);

        Employee employee2 =
                new Employee("Rahul", "EMP102", 70000);

        System.out.println("Employee 1:");
        employee1.displayInfo();

        System.out.println();

        System.out.println("Employee 2:");
        employee2.displayInfo();
    }
}