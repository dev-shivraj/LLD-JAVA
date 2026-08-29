package practice.dip.part1.employee.goodDesign;

public class EmployeeClient {
    public static void main(String[] args) {
        Employee employee = new Employee(1, "Shivraj");

        EmployeeRepository repository = new MySQLEmployeeRepository();
        EmployeeService service = new EmployeeService(repository);
        service.saveEmployee(employee);
        System.out.println("----------------");

        repository = new MongoEmployeeRepository();
        service = new EmployeeService(repository);
        service.saveEmployee(employee);
    }
}