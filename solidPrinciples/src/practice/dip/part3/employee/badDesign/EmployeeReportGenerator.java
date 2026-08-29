package practice.dip.part3.employee.badDesign;

public class EmployeeReportGenerator {

    public void generate(String employee) {

        System.out.println(
                "Generating report for " + employee
        );
    }
}