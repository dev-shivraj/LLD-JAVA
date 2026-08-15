package lambdas.practice.predicate;

import lambdas.practice.entity.Employee;

import java.util.List;
import java.util.function.Predicate;

public class Client {
    public static void main(String[] args) {
        // =====================================================

        // ******** Predicate   *************
//        List<Integer> numbers = List.of(10, 15, 20, 25, 30, 35, 40, 45, 50);
//
//        System.out.println("Even numbers : ");
//        process(numbers, number -> number % 2 == 0);
//
//
//        System.out.println("Odd numbers : ");
//        process(numbers, number -> number % 2 != 0);
//
//        System.out.println("numbers greater than 20 : ");
//        process(numbers, number -> number > 20);
//
//        System.out.println("numbers divisible by 5 : ");
//        process(numbers, number -> number % 5 == 0);
//

        // =====================================================

        // ***********  Predicate Variables     ****************
//        Predicate<Integer> isEven = number -> number % 2 == 0;
//        Predicate<Integer> isOdd = number -> number % 2 != 0;
//
//        Predicate<Integer> isPositive = number -> number > 0;
//        Predicate<Integer> isNegative = number -> number < 0;
//        Predicate<Integer> isZero = number -> number ==0;
//
//
//        System.out.println("isEven: " + isEven.test(10));
//        System.out.println("isEven: " + isEven.test(11));
//
//
//        System.out.println("isOdd: " + isOdd.test(11));
//        System.out.println("isOdd: " + isOdd.test(10));
//
//
//        System.out.println("isPositive: " + isPositive.test(10));
//        System.out.println("isPositive: " + isPositive.test(-10));
//
//
//        System.out.println("isNegative: " + isNegative.test(-10));
//        System.out.println("isNegative: " + isNegative.test(10));
//
//
//        System.out.println("isZero: " + isZero.test(0));
//        System.out.println("isZero: " + isZero.test(10));
        // =====================================================


        //  **************      Predicate With Strings      ****

//        Predicate<String> isEmpty = str -> str.isEmpty();
//        Predicate<String> startsWithA = str -> str.startsWith("A");
//        Predicate<String> longerThanFive = str -> str.length() > 5;
//        Predicate<String> containsJava = str -> str.contains("Java");
//
//        System.out.println("isEmpty : " + isEmpty.test(""));
//        System.out.println("isEmpty : " + isEmpty.test("Shivraj"));
//
//
//        System.out.println("startsWithA : " + startsWithA.test("Arjun"));
//        System.out.println("startsWithA : " + startsWithA.test("Karan"));
//
//
//
//        System.out.println("longerThanFive : " + longerThanFive.test("Shivraj"));
//        System.out.println("longerThanFive : " + longerThanFive.test("Raj"));
//
//
//
//        System.out.println("containsJava : " + containsJava.test("Spring with Java"));
//        System.out.println("containsJava : " + containsJava.test("No Spring"));


        // =====================================================
//        // *******      Predicate Composition       *******
//        Predicate<Integer> isEven = x -> x % 2 == 0;
//        Predicate<Integer> isGreaterThan10 = x -> x > 10;
//
//        Predicate<Integer> evenAndGreaterThan10 = isEven.and(isGreaterThan10);
//        System.out.println(evenAndGreaterThan10.test(10));
//        System.out.println(evenAndGreaterThan10.test(12));
//        System.out.println(evenAndGreaterThan10.test(8));
//
//        System.out.println("------------");
//
//
//        // -----    predicate or    ----------
//        Predicate<Integer> lessThan5 = x -> x < 5;
//        Predicate<Integer> greaterThan20 = x -> x > 20;
//
//        Predicate<Integer> outsideRange = lessThan5.or(greaterThan20);
//
//        System.out.println(outsideRange.test(1));
//        System.out.println(outsideRange.test(100));
//        System.out.println(outsideRange.test(10));
//
//
//        // -----    predicate negate    ----------
//        System.out.println("------------");
//
//        Predicate<Integer> even = x -> x % 2 == 0;
//        Predicate<Integer> odd = even.negate();
//
//        System.out.println(odd.test(11));
//        System.out.println(odd.test(10));

        // =====================================================

        List<Employee> employees = List.of(
                new Employee("A", 25, 50000, "IT"),
                new Employee("B", 32, 120000, "IT"),
                new Employee("C", 28, 90000, "HR"),
                new Employee("D", 40, 150000, "Finance"),
                new Employee("E", 22, 45000, "HR")
        );

        Employee e1 = new Employee("Shivraj", 22, 500000, "IT");
        Employee e2 = new Employee("Raj", 17, 500000, "NON-IT");

        Predicate<Employee> isAdult = employee -> employee.getAge() >= 18;
        Predicate<Employee> highSalary = employee -> employee.getSalary() > 100_000;
        Predicate<Employee> isIT = employee -> "IT".equals(employee.getDepartment());

        Predicate<Employee> eligible = isAdult
                .and(highSalary)
                .and(isIT);

        System.out.println(isAdult.test(e1));
        System.out.println(eligible.test(e1));

        processEmployee(employees, isIT);
        processEmployee(employees, highSalary);
        processEmployee(employees, employee -> employee.getAge() > 25);

        Predicate<Employee> higherPaidITEmployee = highSalary.and(isIT);
        System.out.println("higherPaidITEmployee : " + higherPaidITEmployee.test(e1));

        processEmployee(employees, higherPaidITEmployee);

        Predicate<Employee> highPaidITOrFinance = highSalary.or(isIT).or(departmentIs("Finance"));
        processEmployee(employees, highPaidITOrFinance);

        Predicate<Employee> notIT = isIT.negate();
        processEmployee(employees, notIT);

        Predicate<Employee> notHighSalary = highSalary.negate();
        processEmployee(employees, notHighSalary);

        // =====================================================
        // ******    Build a Predicate dynamically  **********
        Predicate<Employee> greaterThan100K = salaryGreaterThan(100_000);
        Predicate<Employee> greaterThan200K = salaryGreaterThan(200_000);
        Predicate<Employee> greaterThan500K = salaryGreaterThan(500_000);

        processEmployee(employees, greaterThan100K);
        processEmployee(employees, greaterThan200K);
        processEmployee(employees, greaterThan500K);

        // =====================================================
        //  *****   Predicate Factory   ******
        Predicate<Employee> itEmployees = departmentIs("IT");
        Predicate<Employee> hrEmployees = departmentIs("HR");
        Predicate<Employee> financeEmployees = departmentIs("Finance");

        processEmployee(employees, itEmployees);
        processEmployee(employees, hrEmployees);
        processEmployee(employees, financeEmployees);

        // =====================================================
        //  *****   Combine dynamically created predicates  ***
        Predicate<Employee> condition = salaryGreaterThan(100_000).and(departmentIs("IT"));
        processEmployee(employees, condition);

        Predicate<Employee> condition2 = salaryGreaterThan(100_000).and(departmentIs("IT").or(departmentIs("Finance")));
        processEmployee(employees, condition2);

        // =====================================================

        // =====================================================

        // =====================================================
    }

    static void process(List<Integer> numbers, Predicate<Integer> operation) {
        for (int num : numbers) {
            if (operation.test(num)) {
                System.out.print(num + " ");
            }
        }
        System.out.println();
    }

    static void processEmployee(List<Employee> employees, Predicate<Employee> operation) {
        for (Employee employee : employees) {
            if (operation.test(employee)) {
                System.out.println(employee);
            }
        }

        System.out.println("-----------------");
    }


    static Predicate<Employee> salaryGreaterThan (double salary) {
        return employee -> employee.getSalary() > salary;
    }

    static Predicate<Employee> departmentIs(String department) {
        return employee -> employee.getDepartment().equals(department);
    }
}
