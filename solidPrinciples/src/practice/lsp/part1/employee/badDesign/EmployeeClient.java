package practice.lsp.part1.employee.badDesign;

public class EmployeeClient {
    public static void processLeave(Employee employee) {
        employee.approveLeave();
    }

    public static void main(String[] args) {
        Employee manager = new Manager();
        processLeave(manager);

        Employee intern = new Intern();
        processLeave(intern);
    }
}