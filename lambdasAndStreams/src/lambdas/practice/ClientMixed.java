package lambdas.practice;

import lambdas.practice.entity.Employee;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class ClientMixed {
    public static void main(String[] args) {
        // ==================================================

//        Predicate<Employee> isIT = employee -> "IT".equals(employee.getDepartment());
//
//        Employee employee = new Employee("Shivraj", 22, 150_000, "IT");
//        System.out.println(isIT.test(employee));

        // ==================================================

//        Function<Employee, Double> annualSalary = employee -> 12 * employee.getSalary();
//
//        Employee employee = new Employee("Shivraj", 22, 150_000, "IT");
//        System.out.println(annualSalary.apply(employee));

        // ==================================================

//        Consumer<Employee> printName = employee -> System.out.println(employee.getName());
//
//        Employee employee = new Employee("Shivraj", 22, 150_000, "IT");
//        printName.accept(employee);

        // ==================================================

//        Function<Employee, String> upperCaseName = employee -> employee.getName().toUpperCase();
//
//        Employee employee = new Employee("Shivraj", 22, 150_000, "IT");
//        System.out.println(upperCaseName.apply(employee));


        // ==================================================

//        Predicate<Employee> isAdult = employee -> employee.getAge() >= 25;
//        Employee employee = new Employee("Shivraj", 26, 150_000, "IT");
//        System.out.println(isAdult.test(employee));


        // ==================================================

//        Employee employee = new Employee("Shivraj", 22, 150_000, "IT");
//
//        Consumer<Employee> printName = consume(employee, emp -> emp.getName());
//        Consumer<Employee> printDept = consume(employee, emp -> emp.getDepartment());
//        Consumer<Employee> printAge = consume(employee, emp -> emp.getAge());
//        Consumer<Employee> printSalary = consume(employee, emp -> emp.getSalary());
//
//        printName.accept(employee);
//        printDept.accept(employee);
//        printAge.accept(employee);
//        printSalary.accept(employee);
        // ==================================================

//        Supplier<Employee> employeeSupplier = () -> new Employee("Shivraj", 22, 150_000, "IT");
//        Employee employee = employeeSupplier.get();
//
//        Predicate<Employee> isEligible = employee1 -> employee.getAge() >= 18;
//        Function<Employee, String> getName = employee1 -> employee.getName();
//        Consumer<Employee> printName = employee1 -> System.out.println(employee1.getName());
//
//        System.out.println(isEligible.test(employee));
//        System.out.println(getName.apply(employee));
//        printName.accept(employee);




        // ==================================================

        process(
                () -> new Employee("Shivraj", 22, 150_000, "IT"),
                employee -> employee.getSalary() > 100_000,
                employee -> employee.getName(),
                name -> System.out.println("Employee: " + name)
        );


        // ==================================================
    }

    static Consumer<Employee> consume(Employee employee, Function<Employee, ?> function) {
        return employee1 -> System.out.println(function.apply(employee));
    }

    static void process(Supplier<Employee> supplier, Predicate<Employee> predicate, Function<Employee, String> function, Consumer<String> consumer) {
        Employee employee = supplier.get();
        System.out.println(predicate.test(employee));

        System.out.println(function.apply(employee));
        consumer.accept(function.apply(employee));

    }
}
