package lambdas.practice.bi.biPredicate;

import lambdas.practice.entity.Employee;

import java.util.function.BiPredicate;

public class Client {
    public static void main(String[] args) {
        // ==================================================

        BiPredicate<Integer, Integer> isEqual = (a, b) -> a == b;
        System.out.println(isEqual.test(5, 5));
        System.out.println(isEqual.test(5, 10));

        System.out.println("---------------");

        BiPredicate<Integer, Integer> isFirstGreater = (a, b) -> a > b;
        System.out.println(isFirstGreater.test(10, 5));
        System.out.println(isFirstGreater.test(10, 15));

        System.out.println("---------------");

        BiPredicate<Integer, Integer> isFirstDivisibleBySecond = (a, b) -> a % b == 0;

        System.out.println(isFirstDivisibleBySecond.test(10, 5));
        System.out.println(isFirstDivisibleBySecond.test(10, 2));


        System.out.println("---------------");


        BiPredicate<Integer, Integer> isSumGreaterThan100 = (a, b) -> a + b > 100;

        System.out.println(isSumGreaterThan100.test(80, 50));
        System.out.println(isSumGreaterThan100.test(40, 50));

        System.out.println("---------------");

        // ==================================================

        BiPredicate<Employee, String> isBelongingToDept = ((employee, s) -> s.equals(employee.getDepartment()));

        Employee employee = new Employee("Shivraj", 22, 150_000, "IT");
        System.out.println(isBelongingToDept.test(employee, "IT"));
        System.out.println(isBelongingToDept.test(employee, "HR"));

        System.out.println("---------------");



        // ==================================================
    }
}
