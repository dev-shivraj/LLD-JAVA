package practice.fundamentals.instancevariables.practice1;

public class Employee {

    String name;
    String employeeId;
    double salary;
    boolean active;

    void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Salary: " + salary);
        System.out.println("Active: " + active);
    }
}