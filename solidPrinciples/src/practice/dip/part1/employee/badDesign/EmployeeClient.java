package practice.dip.part1.employee.badDesign;

public class EmployeeClient {
    public static void main(String[] args) {
        Employee employee = new Employee(1, "Shivraj");
        EmployeeService service = new EmployeeService();
        service.saveEmployee(employee);
    }
}