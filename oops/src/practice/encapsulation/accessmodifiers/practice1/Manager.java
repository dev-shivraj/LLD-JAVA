package practice.encapsulation.accessmodifiers.practice1;

public class Manager extends Employee {

    public Manager(String name, double salary, String employeeId, String company) {
        super(name, salary, employeeId, company);
    }

    public void increaseSalary(double amount) {

        if (amount <= 0) {
            System.out.println("Amount must be greater than 0.");
            return;
        }

        salary += amount;
    }

    public void displayEmployeeDetails() {

        System.out.println("Name: " + getName());
        System.out.println("Salary: " + salary);
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Company: " + company);
    }
}