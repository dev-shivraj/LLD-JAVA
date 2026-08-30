package practice.lsp.part2.postCondition.employee.badDesign;

public class Intern extends Employee {
    @Override
    public double calculateSalary() {
        return -1;
    }
}