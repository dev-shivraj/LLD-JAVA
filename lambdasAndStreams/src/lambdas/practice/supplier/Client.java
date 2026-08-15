package lambdas.practice.supplier;

import lambdas.practice.entity.Employee;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Client {
    public static void main(String[] args) {
        // =====================================================

//        Supplier<String> supplier = () -> "Hello Shivraj";
//        System.out.println(supplier.get());
//
//        Supplier<Integer> number = () -> 100;
//        System.out.println(number.get());
//
//        Supplier<Double> randomNumber = () -> Math.random();
//        System.out.println(randomNumber.get());


        // =====================================================

//        Supplier<Employee> employeeSupplier  = () -> new Employee("Shivraj", 22, 150_000, "IT");
//        System.out.println(employeeSupplier.get());


        // =====================================================
        // Supplier Factory
//        Supplier<Employee> shivraj = employeeFactory("Shivraj", 22, 150_000, "IT");
//        Supplier<Employee> raj = employeeFactory("RAJ", 22, 50_000, "HR");
//
//
//        System.out.println(shivraj.get());
//        System.out.println(raj.get());

        // =====================================================
        // Supplier + Consumer

//        Supplier<Employee> employeeSupplier = () -> new Employee("Shivraj", 22, 150_000, "IT");
//        Consumer<Employee> printEmployee = employee -> System.out.println(employee);
//
//        printEmployee.accept(employeeSupplier.get());

        // =====================================================
        Supplier<Employee> employeeSupplier = () -> new Employee("Shivraj", 22, 150_000, "IT");
        Consumer<Employee> printName = employee -> System.out.println(employee.getName());
        Consumer<Employee> printSalary = employee -> System.out.println(employee.getSalary());
        Consumer<Employee> printDepartment = employee -> System.out.println(employee.getDepartment());

        Consumer<Employee> printEmployee = printName.andThen(printSalary).andThen(printDepartment);

        Employee emp = new Employee("Shivraj", 22, 150_000, "IT");
        printEmployee.accept(emp);

        // =====================================================



    }

    static Supplier<Employee> employeeFactory(String name, int age, double salary, String department) {
        return () -> new Employee(name, age, salary, department);
    }

}
