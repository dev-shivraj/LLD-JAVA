package practice.dip.part1.employee.badDesign;

public class EmployeeService {
    private final MySQLEmployeeRepository repository = new MySQLEmployeeRepository();

    public void saveEmployee(Employee employee) {
        repository.save(employee);
    }
}