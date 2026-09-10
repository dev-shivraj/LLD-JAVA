package practice.fundamentals.constructoroverloading.practice1;

public class Employee {

    String name;
    double salary;
    String department;

    Employee() {
        name = "Unknown";
        salary = 0;
        department = "Unknown";
    }

    Employee(String name) {
        this.name = name;
        salary = 0;
        department = "Unknown";
    }

    Employee(String name, double salary, String department) {
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Salary: " + salary);
        System.out.println("Department: " + department);
    }
}