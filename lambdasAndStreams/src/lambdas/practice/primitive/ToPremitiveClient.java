package lambdas.practice.primitive;

import lambdas.practice.entity.Employee;

import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;

public class ToPremitiveClient {
    public static void main(String[] args) {

        // =======================================================================
//        ToIntFunction<String> length = x -> x.length();
//        System.out.println(length.applyAsInt("Shivraj"));
//
//        System.out.println("-----------------");
//
//
//        ToIntFunction<String> vowelCount = str -> {
//            int count = 0;
//            for(char ch : str.toCharArray()) {
//                if((ch == 'a') || (ch == 'e') || (ch == 'i') || (ch == 'o') || (ch == 'u')) {
//                    ++count;
//                }
//            }
//            return count;
//        };
//
//
//        System.out.println(length.applyAsInt("shivraj"));
//        System.out.println(vowelCount.applyAsInt("shivraj"));
//
//        System.out.println("-----------------");
//


        // =======================================================================

//        Employee employee = new Employee("Shivraj", 22, 150_000, "IT");
//        ToDoubleFunction<Employee> annualSalary = emp -> emp.getSalary() * 12;
//
//        System.out.println(annualSalary.applyAsDouble(employee));

        // =======================================================================
    }
}