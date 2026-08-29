package practice.dip.part3.employee.goodDesign;

public class EmployeeService {
    private final EmployeeRepository repository;
    private final ReportGenerator reportGenerator;
    private final Notification notification;

    public EmployeeService(EmployeeRepository repository, ReportGenerator reportGenerator, Notification notification) {
        this.repository = repository;
        this.reportGenerator = reportGenerator;
        this.notification = notification;
    }

    public void processEmployee(String employee) {
        repository.save(employee);
        reportGenerator.generate(employee);
        notification.send("Employee processed");
    }
}