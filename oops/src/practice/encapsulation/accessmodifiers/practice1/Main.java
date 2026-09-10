package practice.encapsulation.accessmodifiers.practice1;

public class Main {

    public static void main(String[] args) {

        Manager manager = new Manager(
                "Shivraj",
                80000,
                "EMP101",
                "TechCompany"
        );

        manager.displayEmployeeDetails();
        manager.increaseSalary(10000);

        System.out.println("After salary increase:");
        System.out.println("Salary: " + manager.salary);

        System.out.println("Employee ID: " + manager.employeeId);
        System.out.println("Company: " + manager.company);

        // Not allowed because name is private.
        // System.out.println(manager.name);
    }
}