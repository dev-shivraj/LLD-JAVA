package practice.lsp.part2.postCondition.employee.badDesign;

public class EmployeeClient {
    public static void main(String[] args) {
        Employee employee = new Intern();
        double salary = employee.calculateSalary();
        System.out.println("Salary: " + salary);
    }
}