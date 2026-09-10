package practice.encapsulation.datahiding.practice1;

public class Employee {

    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void increaseSalary(double amount) {

        if (amount <= 0) {
            System.out.println("Salary must be greater than 0.");
            return;
        }

        salary += amount;
    }
}