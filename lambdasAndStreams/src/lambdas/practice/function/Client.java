package lambdas.practice.function;

import lambdas.practice.entity.Employee;

import java.util.List;
import java.util.function.Function;

public class Client {
    public static void main(String[] args) {
        // =====================================================
//        Function<String, String> upperCase = str -> str.toUpperCase();
//        Function<String, String> lowerCase = str -> str.toLowerCase();
//        Function<String, String> reverse = str -> new StringBuilder(str).reverse().toString();
//        Function<String, Integer> length = str -> str.length();
//
//        System.out.println(upperCase.apply("Shivraj"));
//        System.out.println(lowerCase.apply("Shivraj"));
//        System.out.println(reverse.apply("Shivraj"));
//        System.out.println(length.apply("Shivraj"));
//
//        System.out.println("-----------------------");
//
//
//        // without functional interface :
//        Function<String, Integer> length1 = new Function<String, Integer>() {
//            @Override
//            public Integer apply(String s) {
//                return s.length();
//            }
//        };
//
//        System.out.println(length1.apply("Raj"));


        // =====================================================

//        List<Employee> employees = List.of(
//                new Employee("A", 25, 50000, "IT"),
//                new Employee("B", 32, 120000, "IT"),
//                new Employee("C", 28, 90000, "HR"),
//                new Employee("D", 40, 150000, "Finance"),
//                new Employee("E", 22, 45000, "HR")
//        );
//
//        Employee e1 = new Employee("Raj", 22, 150_000, "IT");
//
//        Function<Employee, String> getName = employee -> employee.getName();
//        Function<Employee, Double> getSalary = employee ->  employee.getSalary();
//        Function<Employee, String> getDepartment = employee -> employee.getDepartment();
//
//        System.out.println(getName.apply(e1));
//        System.out.println(getSalary.apply(e1));
//        System.out.println(getDepartment.apply(e1));
//
//        System.out.println("---------------------------------------------------");
//
//




        // =====================================================
        //  ----------------- Transformation    ------------
//        Function<Integer, Integer> square = num -> num * num;
//        System.out.println(square.apply(10));
//
//        Function<Integer, Integer> doubleValue = num -> 2 * num;
//        System.out.println(doubleValue.apply(10));
//
//
//        Function<Integer, String> convertToString = num -> "Number : " +num;
//        System.out.println(convertToString.apply(10));
//
//        Function<Integer, Integer> annualSalary = num -> 12 * num;
//        System.out.println(annualSalary.apply(5_000));
//
//        Function<Employee, Double> employeeAnnualSalary = emp -> 12 * emp.getSalary();
//
//        Employee emp = new Employee("Raj", 22, 150_000, "IT");
//        System.out.println(employeeAnnualSalary.apply(emp));



        // =====================================================
//
//        // **** Function Composition    *****
//        Function<String, String> trim = str -> str.trim();
//        Function<String, String> uppercase = str -> str.toUpperCase();
//
//        Function<String, String> trimAndUppercase = trim.andThen(uppercase);
//
//        System.out.println(trimAndUppercase.apply(" Shivraj     "));



        // =====================================================

        //  *******     andThen() vs compose()      *********
//        Function<Integer, Integer> doubleValue = x -> x * 2;
//        Function<Integer, Integer> addTen = x -> x + 10;
//
//        Function<Integer, Integer> operation = doubleValue.andThen(addTen);
//        System.out.println(operation.apply(5));
//
//
//        Function<Integer, Integer> operation1 = doubleValue.compose(addTen);
//        System.out.println(operation1.apply(5));
//
//        System.out.println("-------------");
//
//        Function<Integer, Integer> multiplyBy2 = num -> num * 2;
//        Function<Integer, Integer> add10 = num -> num + 10;
//
//        Function<Integer, Integer> first = multiplyBy2.andThen(add10);
//        Function<Integer, Integer> second = multiplyBy2.compose(addTen);
//
//        System.out.println(first.apply(5));
//        System.out.println(second.apply(5));
//
//        System.out.println("-------------");
//
//        Function<String, String> trim = str -> str.trim();
//        Function<String, Integer> length = str -> str.length();
//
//        Function<String, Integer> trimAndLength = trim.andThen(length);
//        System.out.println(trimAndLength.apply("    Shivraj     "));



        // =========================================================
        //  *****       Build a Multi-step Employee Pipeline    ****
//        Function<Employee, Double> getSalary = employee -> employee.getSalary();
//        Function<Double, Double> annualSalary = salary -> salary * 12;
//
//        Function<Employee, Double> calculateAnnualSalary = getSalary.andThen(annualSalary);
//
//        Employee emp = new Employee("Raj", 22, 150_000, "IT");
//        System.out.println(calculateAnnualSalary.apply(emp));
//
//
//        System.out.println("-----------");
//
//        Function<Employee, String> getDepartment = employee -> employee.getDepartment();
//        Function<String, String> uppercase = department -> department.toUpperCase();
//        Function<String, String> addPrefix = department -> "DEPARTMENT: " + department;
//        Function<Employee, String> employeeDepartment = getDepartment.andThen(uppercase).andThen(addPrefix);
//
//
//        System.out.println(employeeDepartment.apply(emp));

        // =====================================================

        //  ********    Function.identity()     *******
//        // x -> x  is equivalent to  Function.identity()
//
//        Function<String, String> identity = Function.identity();
//        System.out.println(identity.apply("Shivraj"));



        // =====================================================

        //  *********   Function Factory    *********
//        Function<Double, Double> increment10 = addPercentage(10);
//        Function<Double, Double> increment20 = addPercentage(20);
//
//        System.out.println(increment10.apply(100000.0));
//        System.out.println(increment20.apply(100000.0));


        // =====================================================
        //  *******     Function Factory + Composition  ****

//        Function<Employee, Double> getSalary = employee -> employee.getSalary();
//        Function<Double, Double> increment10 = addPercentage(10);
//
//        Function<Employee, Double> salaryAfterIncrement = getSalary.andThen(increment10);
//
//
//        Employee emp = new Employee("Raj", 22, 100_000, "it");
//        System.out.println(salaryAfterIncrement.apply(emp));

        // =====================================================

//        Employee emp = new Employee("Raj", 22, 150_000, "IT");
//        Function<Employee, String> name = employee -> employee.getName();
//        Function<String, String> upperCase = str -> str.toUpperCase();
//        Function<String, String> addPrefix = str -> "Employee : " + str;
//
//        Function<Employee, String> nameUpperWithPrefix = name.andThen(upperCase).andThen(addPrefix);
//        System.out.println(nameUpperWithPrefix.apply(emp));
//
//
//        Function<Employee, Double> salary = employee -> employee.getSalary();
//        Function<Double, Double> increment = sal -> (double) sal + 10_000;
//
//        Function<Employee, Double> incrementedSalary = salary.andThen(increment);
//        System.out.println((incrementedSalary.apply(emp)));
//
//        Function<Employee, String> department = employee -> employee.getDepartment();
//        Function<String, String> upper = str -> str.toUpperCase();
//        Function<String, String> prefix = str -> "DEPARTMENT : " + str;
//
//        Function<Employee, String> departmentWithPrefixInUpperCase = department.andThen(upper).andThen(prefix);
//
//        System.out.println(departmentWithPrefixInUpperCase.apply(emp));

        // =====================================================
//
//        Employee emp = new Employee("Raj", 22, 150_000, "IT");
//        String name = transform(emp, employee -> employee.getName());
//        System.out.println(name);



        // =====================================================

    }


    static Function<Double, Double> addPercentage(double percentage) {
        return salary -> salary + (salary * percentage / 100);
    }

    static <T, R> R transform(T value, Function<T, R> function) {
        return function.apply(value);
    }

}
