package lambdas.practice.consumer;

import lambdas.Task;
import lambdas.practice.entity.Employee;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class Client {
    public static void main(String[] args) {
        // =====================================================

//        Consumer<String> printer = msg -> System.out.println(msg);
//        printer.accept("Hello Shivraj");
//
//        // uppercase
//        Consumer<String> uppercase = str -> System.out.println(str.toUpperCase());
//        uppercase.accept("hello shivraj!");
//
//        // length
//        Consumer<String> length = str -> System.out.println(str.length());
//        length.accept("Shivraj");

        // =====================================================
//        //  Employee
//        Employee emp = new Employee("Shivraj", 22, 150_000, "IT");
//
//        // print name
//        Consumer<Employee> name = employee -> System.out.println(employee.getName());
//
//        // print salary
//        Consumer<Employee> salary = employee -> System.out.println(employee.getSalary());
//
//
//        // print department
//        Consumer<Employee> dept = employee -> System.out.println(employee.getDepartment());
//
//        name.accept(emp);
//        salary.accept(emp);
//        dept.accept(emp);


        // =====================================================

//        List<Employee> employees = List.of(
//                new Employee("A", 25, 50000, "IT"),
//                new Employee("B", 32, 120000, "IT"),
//                new Employee("C", 28, 90000, "HR"),
//                new Employee("D", 40, 150000, "Finance"),
//                new Employee("E", 22, 45000, "HR")
//        );
//
//        processEmployee(employees, employee -> System.out.print(employee.getName() + " "));
//        processEmployee(employees, employee -> System.out.println(employee));
//        processEmployee(employees, employee -> System.out.println(employee.getName() + " " + employee.getSalary()));

        // =====================================================
//        // Consumer composition
//        Consumer<Employee> printName = employee -> System.out.println(employee.getName());
//        Consumer<Employee> printSalary = employee -> System.out.println(employee.getSalary());
//
//        Consumer<Employee> printNameAndSalary = printName.andThen(printSalary);
//
//        Employee emp = new Employee("Shivraj", 22, 150_000, "IT");
//        printNameAndSalary.accept(emp);


        // =====================================================
//        Consumer<Employee> printName = employee -> System.out.println("Name: " + employee.getName());
//        Consumer<Employee> printSalary = employee -> System.out.println("Salary: " + employee.getSalary());
//        Consumer<Employee> printDepartment = employee -> System.out.println("Department: " + employee.getDepartment());
//
//        Consumer<Employee> printEmployee = printName.andThen(printSalary).andThen(printDepartment);
//
//        Employee emp = new Employee("Shivraj", 22, 150_000, "IT");
//        printEmployee.accept(emp);


        // =====================================================
        //  Consumer Factory

        Consumer<Employee> printName = printField(employee -> employee.getName());
        Consumer<Employee> printSalary = printField(employee -> employee.getSalary());
        Consumer<Employee> printDepartment = printField(employee -> employee.getDepartment());

        Employee emp = new Employee("Shivraj", 22, 150_000, "IT");
        printName.accept(emp);
        printSalary.accept(emp);
        printDepartment.accept(emp);

        // =====================================================

    }

    static void processEmployee(List<Employee> employees, Consumer<Employee> consumer) {
        for(Employee employee : employees) {
            consumer.accept(employee);
        }
        System.out.println("\n----------------");
    }


    static Consumer<Employee> printField(Function<Employee, ?> function) {
        return employee -> System.out.println(function.apply(employee));
    }
}
