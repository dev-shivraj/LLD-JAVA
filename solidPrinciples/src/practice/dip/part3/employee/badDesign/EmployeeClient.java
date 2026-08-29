package practice.dip.part3.employee.badDesign;

public class EmployeeClient {

    public static void main(String[] args) {

        EmployeeService service =
                new EmployeeService();

        service.processEmployee("Shivraj");
    }
}