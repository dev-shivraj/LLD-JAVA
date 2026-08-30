package practice.lsp.part1.employee.badDesign;

public class Intern extends Employee {
    @Override
    public void approveLeave() {
        throw new UnsupportedOperationException("Intern cannot approve leave");
    }
}