package practice.encapsulation.datahiding.practice1;

public class Main {

    public static void main(String[] args) {

        Employee employee = new Employee("Shivraj", 50000);

        System.out.println("Employee: " + employee.getName());
        System.out.println("Salary: " + employee.getSalary());

        employee.increaseSalary(10000);
        System.out.println("Salary after increment: " + employee.getSalary());

        employee.increaseSalary(-5000);
        System.out.println("Final salary: " + employee.getSalary());
    }
}