package practice.encapsulation.accessmodifiers.practice1;

public class Employee {

    private String name;
    protected double salary;
    String employeeId;
    public String company;

    public Employee(String name, double salary, String employeeId, String company) {
        this.name = name;
        this.salary = salary;
        this.employeeId = employeeId;
        this.company = company;
    }

    public String getName() {
        return name;
    }
}