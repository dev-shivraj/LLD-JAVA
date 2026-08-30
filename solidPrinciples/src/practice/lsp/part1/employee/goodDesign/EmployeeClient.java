package practice.lsp.part1.employee.goodDesign;

public class EmployeeClient {
    public static void processEmployee(Employee employee) {
        employee.work();
    }

    public static void processLeave(LeaveApprover employee) {
        employee.approveLeave();
    }

    public static void main(String[] args) {
        Employee intern = new Intern();
        processEmployee(intern);

        LeaveApprover manager = new Manager();
        processEmployee(manager);
        processLeave(manager);
    }
}