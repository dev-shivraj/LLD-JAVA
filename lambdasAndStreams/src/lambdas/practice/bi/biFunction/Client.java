package lambdas.practice.bi.biFunction;


import lambdas.practice.entity.Employee;

import java.util.function.BiFunction;

public class Client {
    public static void main(String[] args) {
        // ==================================================

        BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
        BiFunction<Integer, Integer, Integer> subtract = (a, b) -> a - b;
        BiFunction<Integer, Integer, Integer> multiply = (a, b) -> a * b;
        BiFunction<Integer, Integer, Integer> divide = (a, b) -> a / b;
        BiFunction<Integer, Integer, Integer> max = (a, b) -> Math.max(a, b);
        BiFunction<Integer, Integer, Integer> min = (a, b) -> Math.min(a, b);

        System.out.println(add.apply(10, 20));
        System.out.println(subtract.apply(10, 20));
        System.out.println(multiply.apply(10, 20));
        System.out.println(divide.apply(10, 20));
        System.out.println(max.apply(10, 20));
        System.out.println(min.apply(10, 20));

        System.out.println("----------------------------------");

        // ==================================================

        Employee emp = new Employee("Shivraj", 22, 150_000, "IT");

        BiFunction<Employee, Double, Employee> updated = (employee, increment) -> {
            double salary = employee.getSalary();
            double incrementedSalary = salary + increment;
            return new Employee(employee.getName(), employee.getAge(), incrementedSalary, employee.getDepartment());
        };

        System.out.println(updated.apply(emp, 150_000.0));

        // ==================================================
    }
}
