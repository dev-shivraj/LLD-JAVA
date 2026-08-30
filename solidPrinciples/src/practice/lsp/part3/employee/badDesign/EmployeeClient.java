package practice.lsp.part3.employee.badDesign;

public class EmployeeClient {
    public static void main(String[] args) {
        Employee employee = new Intern();
        employee.work();
        employee.receiveSalary();
        employee.manageTeam();
    }
}