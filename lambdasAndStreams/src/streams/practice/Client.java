package streams.practice;

import lambdas.practice.entity.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Client {
    public static void main(String[] args) {
        // ====================================================================
//        // creating first stream
//        List<Integer> numbers = List.of(10, 20, 30, 40, 50);
//
//        Stream<Integer> stream = numbers.stream();
//        System.out.println(stream);
//
//        // first stream operation
//        numbers.stream().forEach(System.out::println);

        // ====================================================================

//        // filter
//
//        List<Integer> numbers = List.of(10, 15, 20, 25, 30, 35, 40, 45, 50);
//
//        // Create a stream and print every number.
//        numbers.stream().forEach(x -> System.out.println(x));
//        // or
//        numbers.stream().forEach(System.out::println);
//        System.out.println("-----------------------------------");
//
//
//        // Create a stream and print only even numbers.
////        numbers.stream().forEach(x -> {
////            if(x % 2 == 0)
////                System.out.println(x);
////        });
//        numbers.stream()
//                .filter(x -> x % 2 == 0)
//                .forEach(System.out::println);
//        System.out.println("-----------------------------------");
//
//
//
//
//        // Create a stream and print numbers greater than 25.
////        numbers.stream().forEach(x -> {
////            if(x > 25)
////                System.out.println(x);
////        });
//        numbers.stream()
//                .filter(x -> x > 25)
//                .forEach(System.out::println);
//        System.out.println("-----------------------------------");
//
//
//
//        // Create a stream and print numbers divisible by 5.
////        numbers.stream().forEach(x -> {
////            if(x % 5 == 0)
////                System.out.println(x);
////        });
//        numbers.stream()
//                .filter(x -> x % 5 == 0)
//                .forEach(System.out::println);
////        System.out.println("-----------------------------------");


        // ====================================================================

//        // map
//        List<Integer> numbers = List.of(10, 20, 30, 40, 50);
//
//        numbers.stream()
//                .map(x -> x * 2)
//                .forEach(System.out::println);
//
//        System.out.println("---------------");
//
//        Stream<String> numberWithPrefix = numbers.stream()
//                .map(x -> "Number is : " + x);
//        numberWithPrefix.forEach(System.out::println);
//
//        System.out.println("---------------");
//
//
//        numbers.stream()
//                .map(x -> "Number is : " + x)
//                .forEach(System.out::println);

        // ====================================================================

//        List<Employee> employees = List.of(
//                new Employee("Shivraj", 22, 150_000, "IT"),
//                new Employee("Raj", 25, 50_000, "IT"),
//                new Employee("Shukla", 28, 90000, "HR"),
//                new Employee("Arman", 28, 200_000, "HR")
//        );
//
//        // print employees annual salary
//        employees.stream()
//                .map(employee -> employee.getSalary() * 12)
//                .forEach(System.out::println);
//        System.out.println("----------------------");
//
//
//        // print employees name
//        employees.stream()
//                .map(employee -> employee.getName())
//                .forEach(System.out::println);
//        System.out.println("----------------------");
//
//        // print name of employees whose salary is greater than 100_000
//        employees.stream()
//                .filter(employee -> employee.getSalary() > 100_000)
//                .map(employee -> employee.getName())
//                .forEach(System.out::println);
//        System.out.println("----------------------");
//
//        // transform strings to uppercase
//        List<String> names = List.of("Shivraj", "Raj", "Amit", "John");
//        names.stream()
//                .map(name -> name.toUpperCase())
//                .forEach(System.out::println);
//        System.out.println("----------------------");
//
//        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
//        numbers.stream()
//                .map(num -> num * num)
//                .forEach(System.out::println);
//        System.out.println("----------------------");

        // ====================================================================
        // sorted


//        List<Integer> numbers = List.of(50, 10, 40, 20, 30);
//
//        // sort the number in ascending order
//        numbers.stream()
//                .sorted()
//                .forEach(System.out::println);
//        System.out.println("------------------");
//
//        // sort the numbers in descending order
//        numbers.stream()
//                .sorted((a, b) -> b - a) // or better to avoid integer overflow : instead of b - a, use Integer.compare(b, a)
//                .forEach(System.out::println);
//        System.out.println("------------------");
//
//        numbers.stream()
//                .sorted(Comparator.reverseOrder())
//                .forEach(System.out::println);
//        System.out.println("------------------");
//
//
//        List<Employee> employees = List.of(
//                new Employee("Shivraj", 22, 150_000, "IT"),
//                new Employee("Raj", 25, 50_000, "IT"),
//                new Employee("Shukla", 28, 90000, "HR"),
//                new Employee("Arman", 29, 200_000, "HR"),
//                new Employee("Rahul", 29, 100_000, "SELLS")
//        );
//
//        // sort employee based on their salary
//        employees.stream()
//                .sorted(Comparator.comparing(Employee::getSalary))
//                .forEach(System.out::println);
//        System.out.println("------------------");
//
//        // sort employee based on their salary in descending order
//        employees.stream()
//                .sorted(Comparator.comparing(Employee::getSalary).reversed())
//                .forEach(System.out::println);
//        System.out.println("------------------");
//
//        // sort employee based on their age
//        employees.stream()
//                .sorted(Comparator.comparing(Employee::getAge))
//                .forEach(System.out::println);
//        System.out.println("------------------");
//
//        // sort employee based on their age in descending order
//        employees.stream()
//                .sorted(Comparator.comparing(Employee::getAge).reversed())
//                .map(employee -> employee.getName())
//                .forEach(System.out::println);
//        System.out.println("------------------");
//
//        // print employee along with the department sorted by department in ascending order
//        employees.stream()
//                .sorted(Comparator.comparing(Employee::getDepartment))
//                .map(employee -> employee.getName() + " is working in " + employee.getDepartment() + " department.")
//                .forEach(System.out::println);
//        System.out.println("------------------");
//
//        // sort employee by age and if age is same then sort by salary
//        employees.stream()
//                .sorted(Comparator.comparing(Employee::getAge)
//                        .thenComparing(Employee::getSalary))
//                .forEach(System.out::println);
//
////        // we can do :
////        Comparator.comparing(Employee::getDepartment)
////                .thenComparing(Employee::getAge)
////                .thenComparing(Employee::getSalary)
//


        // ====================================================================
        // distinct



        // ====================================================================


        // ====================================================================


        // ====================================================================
    }
}
