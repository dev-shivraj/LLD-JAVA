package practice.lsp.part1.employee.badDesign;

public class Manager extends Employee {
    @Override
    public void approveLeave() {
        System.out.println("Manager approved leave");
    }
}