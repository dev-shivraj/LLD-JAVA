package lambdas.practice.bi.BiConsumer;

import lambdas.practice.entity.Employee;

import java.util.function.BiConsumer;

public class Client {
    public static void main(String[] args) {
        // ==================================================

        BiConsumer<String, String> fullName = (firstName, secondName) -> System.out.println(firstName + " " + secondName);
        fullName.accept("Shivraj", "Kumar");


        BiConsumer<String, Double> printSalary = (name, salary) -> System.out.println(name + " : having salary : " + salary);
        printSalary.accept("Shivraj", 150_000.0);

        BiConsumer<String, String> printDept = (name, dept) -> System.out.println(name + " : belongs to department : " + dept);
        printDept.accept("Shivraj", "IT");

        // ==================================================

        Employee emp = new Employee("Shivraj", 22, 150_000, "IT");

        BiConsumer<Employee, Double> giveRaise = (employee, amount) -> employee.setSalary(employee.getSalary() + amount);
        giveRaise.accept(emp, 10_000.0);
        System.out.println(emp);

        // ==================================================

    }
}
