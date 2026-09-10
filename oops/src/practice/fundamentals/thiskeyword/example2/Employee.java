package practice.fundamentals.thiskeyword.example2;

public class Employee {

    String name;
    double salary;

    void setName(String name) {
        this.name = name;
    }

    void setSalary(double salary) {
        this.salary = salary;
    }

    void displayInfo() {
        System.out.println("Name: " + this.name);
        System.out.println("Salary: " + this.salary);
    }
}