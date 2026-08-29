package practice.dip.part3.employee.goodDesign;

public class EmployeeReportGenerator implements ReportGenerator {
    @Override
    public void generate(String employee) {
        System.out.println("Generating report for " + employee);
    }
}