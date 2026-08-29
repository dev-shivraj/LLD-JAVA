package practice.dip.part3.employee.goodDesign;

public class EmployeeClient {
    public static void main(String[] args) {
        EmployeeRepository repository = new MySQLEmployeeRepository();
        ReportGenerator reportGenerator = new EmployeeReportGenerator();
        Notification notification = new EmailNotification();
        EmployeeService service = new EmployeeService(repository, reportGenerator, notification);
        service.processEmployee("Shivraj");
        System.out.println("----------------");

        repository = new MongoEmployeeRepository();
        service = new EmployeeService(repository, reportGenerator, notification);
        service.processEmployee("Shivraj");
    }
}