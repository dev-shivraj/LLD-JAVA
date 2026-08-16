package lambdas.practice.methodreference;

import lambdas.practice.entity.Employee;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Client {
    public static void main(String args[]) {
        // ==================================================================================
//        Function<String, Integer> length = String::length;
//        Function<String, String> upper = String::toUpperCase;
//        Function<String, String> lower = String::toLowerCase;
//
//        System.out.println(length.apply("Shivraj"));
//        System.out.println(upper.apply("Shivraj"));
//        System.out.println(lower.apply("Shivraj"));
//
//
//        System.out.println("-------------------");

        // ==================================================================================

//        Consumer<String> printer = System.out::println;
//        printer.accept("Shivraj");
//
//        System.out.println("-------------------");

        // ==================================================================================


//
//        Consumer<String> printer1 = str -> System.out.println(str.toUpperCase());
//        // to method reference
//        Function<String, String> upperCase = String::toUpperCase;
//        Consumer<String> print = System.out::println;
//        Consumer<String> printUpperCase = str -> print.accept(upperCase.apply(str));
//        printUpperCase.accept("Shivraj");
//
//

        // ==================================================================================
//        // type 1. static method reference
//        System.out.println("-------------------");
//
//        Function<Integer, Integer> absolute = Math::abs;
//        Function<Double, Double> sqrt = Math::sqrt;
//
//        System.out.println(absolute.apply(-2));
//        System.out.println(sqrt.apply(9.0));


        // ==================================================================================
        // type 2. Instance method reference on a particular object
//        System.out.println("--------------------------------");
//        String name = "Shivraj";
//        Supplier<Integer> length1 = () -> name.length();
//
//        // with function reference :
//        Supplier<Integer> len = name::length;
//        System.out.println(length1.get());
//        System.out.println(len.get());
//
//        Supplier<String> upperCase = name::toUpperCase;
//        System.out.println(upperCase.get());




        // ==================================================================================
        // type 3. Instance method reference on arbitrary object
//
//        // Function<String, Integer> length = str -> str.length();
//
//        Function<String, Integer> length = String::length;
//
//        // here we need to use apply function : length.apply("Shivraj")
//        System.out.println(length.apply("Shivraj"));
//
//
//        String name = "Shivraj";
//        Supplier<Integer> len = name::length;
//
//        // here no argument is required as "Shivraj" ia already passed to method reference : object is already known
//        System.out.println(len.get());
//
//
//        System.out.println("---------------------------------------------------");
//        Function<Employee, String> getName = Employee::getName;
//        Employee employee = new Employee("Shivraj", 22, 150_000, "IT");
//
//        Supplier<String> getName1 = employee::getName;
//
//
//        // notice the distinction here, for one we need to paas the employee, for another we don't
//        System.out.println(getName.apply(employee));
//        System.out.println(getName1.get());
//
//        System.out.println("---------------------------------------------------");
//
//        Function<Employee, Double> getSalary = Employee::getSalary;
//        Function<Employee, String > getDepartment = Employee::getDepartment;
//        Function<Employee, Integer> getAge = Employee::getAge;
//
//        System.out.println(getSalary.apply(employee));
//        System.out.println(getDepartment.apply(employee));
//        System.out.println(getAge.apply(employee));


        // ==================================================================================
        // 4. Constructor reference
        Supplier<Employee> employeeSupplier =  () -> new Employee();

        // with method reference :
        // new -> new Employee()
        Supplier<Employee> employeeSupplier1 = Employee::new;


        // with parameters
        EmployeeCreater creater = Employee::new;

        Employee employee = creater.create("Shivraj", 22, 150_000, "IT");
        System.out.println(employee);




        // ==================================================================================


        // ==================================================================================

    }
}
