package practice.srp.part1.employee.badDesign;

public class Employee {
    int id;
    String name;
    double salary;

    public void calculateSalary() {
        System.out.println("Calculating salary");
    }

    public void calculateBonus() {
        System.out.println("Calculating bonus");
    }

    public void calculateTax() {
        System.out.println("Calculating tax");
    }

    public void saveToDatabase() {
        System.out.println("Saving employee to database");
    }

    public void generatePayslip() {
        System.out.println("Generating payslip");
    }

    public void sendEmail() {
        System.out.println("Sending email");
    }
}