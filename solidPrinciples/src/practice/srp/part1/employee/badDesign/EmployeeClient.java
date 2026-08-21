package practice.srp.part1.employee.badDesign;

public class EmployeeClient {
    public static void main(String[] args) {
        Employee employee = new Employee();

        employee.calculateSalary();
        employee.calculateBonus();
        employee.calculateTax();
        employee.saveToDatabase();
        employee.generatePayslip();
        employee.sendEmail();
    }
}
