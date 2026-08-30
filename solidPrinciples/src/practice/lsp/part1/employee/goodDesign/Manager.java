package practice.lsp.part1.employee.goodDesign;

public class Manager extends LeaveApprover {
    @Override
    public void approveLeave() {
        System.out.println("Manager approved leave");
    }
}