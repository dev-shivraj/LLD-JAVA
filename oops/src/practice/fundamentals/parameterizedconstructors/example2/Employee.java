package practice.fundamentals.parameterizedconstructors.example2;

public class Employee {

    String name;
    String employeeId;
    double salary;

    Employee(String name, String employeeId, double salary) {
        this.name = name;
        this.employeeId = employeeId;
        this.salary = salary;
    }

    void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Salary: " + salary);
    }
}