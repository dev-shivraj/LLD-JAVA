package comparablecomparator.practice.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        // =================================================
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(101, "Shivraj", 150_000.00));
        employees.add(new Employee(102, "Raj", 50_000.00));
        employees.add(new Employee(103, "Shukla", 200_000.00));

        Collections.sort(employees);
        System.out.println(employees);
        System.out.println("------------------");

        // =================================================

        List<Product> products = new ArrayList<>();
        products.add(new Product(101, "Laptop", 80_000.00));
        products.add(new Product(102, "Phone", 50_000.00));
        products.add(new Product(103, "Mouse", 20_000.00));

        Collections.sort(products);
        System.out.println(products);
        System.out.println("------------------");

        // =================================================

        List<Student> students = new ArrayList<>();
        students.add(new Student(101, "Amit", 85));
        students.add(new Student(102, "Rahul", 92));
        students.add(new Student(103, "Shivraj", 78));

        Collections.sort(students);
        System.out.println(students);
        System.out.println("------------------");

        // =================================================
    }
}
