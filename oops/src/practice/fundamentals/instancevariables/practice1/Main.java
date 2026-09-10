package practice.fundamentals.instancevariables.practice1;

public class Main {

    public static void main(String[] args) {

        Employee employee1 = new Employee();
        employee1.name = "Shivraj";
        employee1.employeeId = "EMP101";
        employee1.salary = 80000;
        employee1.active = true;

        Employee employee2 = new Employee();
        employee2.name = "Rahul";
        employee2.employeeId = "EMP102";
        employee2.salary = 70000;
        employee2.active = true;

        System.out.println("Employee 1:");
        employee1.displayInfo();

        System.out.println();

        System.out.println("Employee 2:");
        employee2.displayInfo();

        employee1.salary = 90000;

        System.out.println();
        System.out.println("After updating employee1 salary:");

        System.out.println("Employee 1 salary: " + employee1.salary);
        System.out.println("Employee 2 salary: " + employee2.salary);
    }
}