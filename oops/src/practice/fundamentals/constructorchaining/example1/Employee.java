package practice.fundamentals.constructorchaining.example1;

public class Employee {

    String name;
    double salary;

    Employee() {
        this("Unknown", 0);
    }

    Employee(String name) {
        this(name, 0);
    }

    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Salary: " + salary);
    }
}