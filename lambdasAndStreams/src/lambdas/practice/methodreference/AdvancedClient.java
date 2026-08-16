package lambdas.practice.methodreference;

import lambdas.practice.entity.Employee;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class AdvancedClient {
    static void main() {
        // ======================================================
//        Function<Integer, Integer> absolute = Math::abs;
//        Function<Double, Double> floor = Math::floor;
//        Function<Double, Double> ceil = Math::ceil;
//        Function<Double, Long> round = Math::round;
//
//        System.out.println(absolute.apply(-5));
//        System.out.println(floor.apply(5.4));
//        System.out.println(ceil.apply(5.4));
//        System.out.println(round.apply(5.4));

        // ======================================================
//        Function<String, Integer> len = String::length;
//        Function<String, String> upper = String::toUpperCase;
//        Function<String, String> lower = String::toLowerCase;
//        Function<String, String> trim = String::trim;
//        Function<String, String> strip = String::strip;
//
//        System.out.println(len.apply("Shivraj"));
//        System.out.println(upper.apply("Shivraj"));
//        System.out.println(lower.apply("Shivraj"));
//        System.out.println(trim.apply("     Shivraj     "));
//        System.out.println(strip.apply(" . Shivraj . "));

        // ======================================================

//        Employee employee = new Employee("Shivraj", 22, 150_000, "IT");
//
//        Function<Employee, String> getName = Employee::getName;
//        Function<Employee, Integer> getAge = Employee::getAge;
//        Function<Employee, Double> getSalary = Employee::getSalary;
//        Function<Employee, String> getDepartment = Employee::getDepartment;
//
//        System.out.println(getName.apply(employee));
//        System.out.println(getAge.apply(employee));
//        System.out.println(getSalary.apply(employee));
//        System.out.println(getDepartment.apply(employee));
//
//        System.out.println("--------------------------");
//
//        Supplier<String> name = employee::getName;
//        Supplier<Integer> age = employee::getAge;
//        Supplier<Double> salary = employee::getSalary;
//        Supplier<String> department = employee::getDepartment;
//
//        System.out.println(name.get());
//        System.out.println(age.get());
//        System.out.println(salary.get());
//        System.out.println(department.get());

        // ======================================================

//        Employee employee = new Employee("Shivraj", 22, 150_000, "IT");
//
//
//        Consumer<Employee> printName = emp -> System.out.println(emp.getName());
//        printName.accept(employee);
//        System.out.println("-------------------------");
//
//        // method reference
//        Function<Employee, String> getName = Employee::getName;
//        Consumer<String> print = System.out::print;
//
//        print.accept(getName.apply(employee));


        // ======================================================

//        EmployeeCreater employeeCreater = Employee::new;
//        employeeCreater.create("Raj", 25, 50_000, "HR");

        // ======================================================

        Employee employee = new Employee("Shivraj", 22, 150_000, "IT");

        String name = transform(employee, Employee::getName);
        Double salary = transform(employee, Employee::getSalary);
        String department = transform(employee, Employee::getDepartment);

        System.out.println(name);
        System.out.println(salary);
        System.out.println(department);


        // ======================================================


        // ======================================================
    }

    static <T, R> R transform(T value, Function<T, R> function) {
        return function.apply(value);
    }
}
