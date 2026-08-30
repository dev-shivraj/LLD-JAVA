package practice.lsp.part3.employee.goodDesign;

public class EmployeeClient {
    public static void main(String[] args) {
        Employee intern = new Intern();
        intern.work();
        intern.receiveSalary();
        System.out.println("----------------");

        Manager manager = new Manager();
        manager.work();
        manager.receiveSalary();
        manager.manageTeam();
    }
}