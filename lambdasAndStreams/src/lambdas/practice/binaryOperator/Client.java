package lambdas.practice.binaryOperator;

import lambdas.practice.entity.Employee;

import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Client {
    public static void main(String[] args) {
        // ==================================================

        BinaryOperator<Integer> add = (a, b) -> a + b;
        BinaryOperator<Integer> subtract = (a, b) -> a - b;
        BinaryOperator<Integer> multiply = (a, b) -> a * b;
        BinaryOperator<Integer> divide = (a, b) -> a / b;
        BinaryOperator<Integer> max = (a, b) -> Math.max(a, b);
        BinaryOperator<Integer> min = (a, b) -> Math.min(a, b);

        System.out.println(add.apply(10, 4));
        System.out.println(subtract.apply(10, 4));
        System.out.println(multiply.apply(10, 4));
        System.out.println(divide.apply(10, 4));
        System.out.println(max.apply(10, 4));
        System.out.println(min.apply(10, 4));

        System.out.println("-------------------------------");

        BinaryOperator<String> fullName = (firstName, lastName) -> firstName + " " + lastName;
        System.out.println(fullName.apply("Shivraj", "Kumar"));

        System.out.println("-------------------------------");

        // ==================================================

        BinaryOperator<Employee> higherSalary = (employee1, employee2) -> employee1.getSalary() >= employee2.getSalary() ? employee1 : employee2;

        Employee emp1 = new Employee("Shivraj", 22, 150_000, "IT");
        Employee emp2 = new Employee("Raj", 22, 50_000, "HR");

        Employee higherSalariedEmployee = higherSalary.apply(emp1, emp2);
        System.out.println(higherSalariedEmployee.getName() + " is having higher salary and it's salary is : " + higherSalariedEmployee.getSalary());


        System.out.println("-------------------------------");

        // ==================================================

        BinaryOperator<String> fullNameInUppercase = (str1, str2) -> str1.toUpperCase() + " " + str2.toUpperCase();
        System.out.println(combine("Shivraj", "Kumar", fullNameInUppercase));


        // ==================================================

    }

    static <T> T combine(T first, T second, BinaryOperator<T> operator) {
        return operator.apply(first, second);
    }
}
