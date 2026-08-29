package practice.dip.part1.employee.goodDesign;

public class EmployeeService {
    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public void saveEmployee(Employee employee) {
        repository.save(employee);
    }
}