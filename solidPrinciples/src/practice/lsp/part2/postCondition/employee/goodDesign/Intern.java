package practice.lsp.part2.postCondition.employee.goodDesign;

public class Intern extends Employee {
    @Override
    public double calculateSalary() {
        // satisfy salary > 0
        return 20000;
    }
}