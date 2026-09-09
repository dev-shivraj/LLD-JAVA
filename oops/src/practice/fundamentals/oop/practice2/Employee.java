package practice.fundamentals.oop.practice2;

public class Employee {
    String name;
    String employeeId;
    double salary;
    String department;

    void work() {
        System.out.println(name + " is working");
    }

    void takeLeave() {
        System.out.println(name + " is taking leave");
    }

    void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Salary: " + salary);
        System.out.println("Department: " + department);
    }
}
