package lambdas.practice.unaryOperator;

import lambdas.practice.entity.Employee;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Client {
    public static void main(String[] args) {
        // ==================================================

        UnaryOperator<Integer> square = x -> x * x;
        UnaryOperator<Integer> doubleValue = x -> 2 * x;
        UnaryOperator<Integer> cube = x -> x * x * x;
        UnaryOperator<Integer> increment = x -> x + 1;
        UnaryOperator<Integer> decrement = x -> x - 1;
        UnaryOperator<Integer> absolute = x -> Math.abs(x);

        System.out.println(square.apply(4));
        System.out.println(doubleValue.apply(4));
        System.out.println(cube.apply(4));
        System.out.println(increment.apply(4));
        System.out.println(decrement.apply(4));
        System.out.println(absolute.apply(-4));

        System.out.println("-------------------------");

        UnaryOperator<String> uppercase = str -> str.toUpperCase();
        UnaryOperator<String> reverse = str -> new StringBuilder(str).reverse().toString();
        UnaryOperator<String> addPrefix = str -> "Employee : " + str;

        System.out.println(uppercase.apply("Shivraj"));
        System.out.println(reverse.apply("Shivraj"));
        System.out.println(addPrefix.apply("Shivraj"));

        System.out.println("-------------------------");

        // ==================================================

        UnaryOperator<Employee> giveRaise = employee -> {
            employee.setSalary(employee.getSalary() + 10_000);
            return employee;
        };

        Employee emp = new Employee("Shivraj", 22, 150_000, "IT");
        System.out.println(giveRaise.apply(emp));


        // ==================================================

        UnaryOperator<Integer> add10 = x -> x + 10;
        UnaryOperator<Integer> multiplyBy2 = x -> x * 2;

        Function<Integer, Integer> operation = add10.andThen(multiplyBy2);
        Function<Integer, Integer> operationCompose = add10.compose(multiplyBy2);


        System.out.println(operation.apply(10));
        System.out.println(operationCompose.apply(10));


        System.out.println("---------------");

        // ==================================================

        UnaryOperator<Integer> multiplyBy10 = x -> x * 10;
        System.out.println(operate(5, multiplyBy10));

        // ==================================================

    }

    static <T> T operate(T value, UnaryOperator<T> operator) {
        return operator.apply(value);
    }
}
