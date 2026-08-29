package practice.dip.part3.employee.badDesign;

public class EmployeeService {

    private final MySQLEmployeeRepository repository =
            new MySQLEmployeeRepository();

    private final EmployeeReportGenerator reportGenerator =
            new EmployeeReportGenerator();

    private final EmailNotification notification =
            new EmailNotification();

    public void processEmployee(String employee) {

        repository.save(employee);

        reportGenerator.generate(employee);

        notification.send(
                "Employee processed"
        );
    }
}