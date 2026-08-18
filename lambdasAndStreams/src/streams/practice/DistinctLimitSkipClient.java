package streams.practice;

import java.util.List;

public class DistinctLimitSkipClient {
    public static void main(String[] args) {

        // ================================================================
        // distinct
//        List<Integer> numbers = List.of(40, 20, 10, 30, 20, 30);
//
//        // distinct value from numbers
//        // note: distinct do preserve the stream’s encounter order
//        numbers.stream()
//                .distinct()
//                .forEach(System.out::println);
//
//        System.out.println("-------------------");
//
//
//
//        // distinct sorted
//        numbers.stream()
//                .distinct()
//                .sorted()
//                .forEach(System.out::println);
//
//        System.out.println("-------------------");
//
//
//        // sorted distinct
//        numbers.stream()
//                .sorted()
//                .distinct()
//                .forEach(System.out::println);
//
//        System.out.println("-------------------");
//
//
//
//
//        // distinct with strings
//        List<String> names = List.of(
//                "Shivraj",
//                "Raj",
//                "Shivraj",
//                "Amit",
//                "Raj",
//                "John"
//        );
//
//
//        names.stream()
//                .distinct()
//                .forEach(System.out::println);
//
        // ================================================================

//        List<Employee> employees = List.of(
//                new Employee("Shivraj", 22, 150_000, "IT"),
//                new Employee("Raj", 25, 50_000, "IT"),
//                new Employee("Shivraj", 22, 150_000, "IT")
//        );
//
//        // it will give all the employees
//        // as all three object created with new keyword and points to different location
//        // distinct relies on : hashCode() and equals()
//        employees.stream()
//                .distinct()
//                .forEach(System.out::println);
//
//        // if we override Employee's hashCode and equals method
//        // and make it same based on some parameter like name, department etc
//        // then above one returns the distinct employee based on that particular parameter
//        // otherwise not.
//        // distinct does not take any lambda like map, filter


        // ================================================================
        // Combine filter(), distinct(), sorted()
//        List<Integer> numbers = List.of(50, 10, 30, 20, 10, 40, 30, 50, 60, 20);
//
//        // unique number greater than 20
//        numbers.stream()
//                .filter(x -> x > 20)
//                .distinct()
//                .forEach(System.out::println);
//
//        System.out.println("------------------");
//
//
//        // if we want sorted
//        numbers.stream()
//                .filter(x -> x > 20)
//                .distinct()
//                .sorted()
//                .forEach(System.out::println);
//
//        System.out.println("------------------");
//
//
//        // get unique numbers, square them and sort them
//        numbers.stream()
//                .distinct()
//                .map(x -> x * x)
//                .sorted()
//                .forEach(System.out::println);
//
//        System.out.println("------------------");

        // ================================================================
//        List<Integer> numbers = List.of(15, 50, 20, 25, 75, 15, 25, 10, 50, 30, 75, 20, 40, 10);
//
//        // print unique numbers
//        numbers.stream()
//                .distinct()
//                .forEach(System.out::println);
//        System.out.println("-----------------");
//
//
//        // print unique even numbers
//        numbers.stream()
//                .distinct()
//                .filter(x -> x % 2 == 0)
//                .forEach(System.out::println);
//
//        System.out.println("--------------------");
//
//
//
//        // print unique even numbers in ascending order
//        numbers.stream()
//                .distinct()
//                .filter(x -> x % 2 == 0)
//                .sorted()
//                .forEach(System.out::println);
//
//        System.out.println("--------------------");
//
//
//        // print unique even numbers in descending order
//        numbers.stream()
//                .distinct()
//                .filter(x -> x % 2 == 0)
//                .sorted((a, b) -> Integer.compare(b, a))
//                .forEach(System.out::println);
//
//        System.out.println("-------------------");
//
//
//
//        List<String> names = List.of(
//                "Shivraj",
//                "Raj",
//                "Amit",
//                "Shivraj",
//                "RAJ",
//                "Raj",
//                "Amit"
//        );
//
//        // print unique names
//        names.stream()
//                .distinct()
//                .forEach(System.out::println);
//
//        System.out.println("---------------------");
//
//
//
//        // print unique uppercase names
//        names.stream()
//                .map(x -> x.toUpperCase())
//                .distinct()
//                .forEach(System.out::println);
//
//        System.out.println("---------------------");


        // ================================================================

//        List<Employee> employees = List.of(
//                new Employee("Shivraj", 22, 150_000, "IT"),
//                new Employee("Raj", 25, 50_000, "IT"),
//                new Employee("Arya", 22, 150_000, "IT")
//        );
//
//        // employees whose salary is greater than 50,000, sort them by salary descending, and print only their names.
//        employees.stream()
//                .filter(emp -> emp.getSalary() > 50_000)
//                .sorted((a, b) -> Double.compare(b.getSalary(), a.getSalary()))
//                .map(employee -> employee.getName())
//                .forEach(System.out::println);
//
//        System.out.println("------------------");

        // ================================================================
        // limit()

//        List<Integer> numbers = List.of(10, 20, 30, 40, 50);
//        numbers.stream()
//                .limit(3)
//                .forEach(System.out::println);
//
//        System.out.println("----------------");
//
//
//
//        numbers.stream()
//                .skip(3)
//                .forEach(System.out::println);
//
//        System.out.println("----------------");
//
//
//        numbers.stream()
//                .skip(2)
//                .limit(2)
//                .forEach(System.out::println); // 30, 40
//
//        System.out.println("------------------");
//
//
//        // order matters if we combine skip and limit
//        numbers.stream()
//                .limit(2)
//                .skip(2)
//                .forEach(System.out::println); // gives nothing
//
//        System.out.println("------------------");

        // ================================================================
        // filter() + limit()
//        List<Integer> numbers = List.of(10, 15, 20, 25, 30, 35, 40, 45, 50);
//
//        // get first 3 even numbers
//        numbers.stream()
//                .filter(x -> x % 2 == 0)
//                .limit(3)
//                .forEach(System.out::println);
//
//        System.out.println("----------------");
//
//
//
//        // if we reverse filter and limit order
//        numbers.stream()
//                .limit(3)
//                .filter(x -> x % 2 == 0)
//                .forEach(System.out::println);
//
//        System.out.println("------------------");

        // ================================================================
        // distinct() + limit()

//        List<Integer> numbers = List.of(10, 20, 10, 30, 20, 40, 50);
//
//
//        // get first 3 unique numbers
//        numbers.stream()
//                .distinct()
//                .limit(3)
//                .forEach(System.out::println);
//
//        System.out.println("-----------------");


        // ================================================================
        // sorted() + limit()

//        List<Employee> employees = List.of(
//                new Employee("Shivraj", 22, 150_000, "IT"),
//                new Employee("Raj", 25, 50_000, "SELLS"),
//                new Employee("Arya", 22, 10_000, "HR"),
//                new Employee("Rohan", 22, 500_000, "IT"),
//                new Employee("Divya", 22, 200_000, "IT"),
//                new Employee("Ruhi", 22, 75_000, "MARKETING"),
//                new Employee("Rahul", 22, 125_000, "IT"),
//                new Employee("Rohit", 22, 125_000, "HR"),
//                new Employee("Karan", 22, 125_000, "IT"),
//                new Employee("Nayan", 22, 125_000, "MARKETING"),
//                new Employee("Roshni", 22, 125_000, "IT"),
//                new Employee("Pankaj", 22, 125_000, "IT"),
//                new Employee("Salman", 22, 125_000, "MARKETING"),
//                new Employee("Raghav", 22, 125_000, "IT"),
//                new Employee("Dimple", 22, 125_000, "HR"),
//                new Employee("Karina", 22, 125_000, "IT")
//        );
//
//
//        // find the 3 lowest salaries:
//        employees.stream()
//                .sorted((a, b) -> Double.compare(a.getSalary(), b.getSalary()))
//                .limit(3)
//                .forEach(System.out::println);
//
//        System.out.println("-------------------");
//
//
//
//        // find the 3 highest salaries
//        employees.stream()
//                .sorted((a, b) -> Double.compare(b.getSalary(), a.getSalary()))
//                .limit(3)
//                .forEach(System.out::println);
//
//        System.out.println("------------------");
//
//
//        // get the name of top 3 highest paid employee working in IT having salary greater than 50K
//        employees.stream()
//                .filter(employee -> "IT".equals(employee.getDepartment()))
//                .filter(employee -> employee.getSalary() > 50_000)
//                .sorted((a, b) -> Double.compare(b.getSalary(), a.getSalary()))
//                .limit(3)
//                .map(employee -> employee.getName())
//                .forEach(System.out::println);
//
//        System.out.println("-----------------");

        // ================================================================
        // peek

        List<Integer> numbers = List.of(10, 20, 30, 15, 25);
        numbers.stream()
                .filter(x -> x % 2 == 0)
                .peek(x -> System.out.println("After filter: " + x))
                .map(x -> x * 2)
                .peek(x -> System.out.println("After map: " + x))
                .forEach(System.out::println);

        System.out.println("-------------------------");

        // ================================================================


        // ================================================================
    }
}
