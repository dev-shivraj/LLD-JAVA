package practice.srp.part1.employee.goodDesign;

public class EmployeeClient {
    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.calculateSalary();

        System.out.println("-------------");
        EmployeeCompensation employeeCompensation = new EmployeeCompensation();
        employeeCompensation.calculateBonus(employee);
        employeeCompensation.calculateTax(employee);


        System.out.println("-------------");
        EmployeeNotificationService employeeNotificationService = new EmployeeNotificationService();
        employeeNotificationService.sendEmail(employee);


        System.out.println("-------------");
        EmployeeRepository employeeRepository = new EmployeeRepository();
        employeeRepository.saveToDatabase(employee);


        System.out.println("-------------");
        PayslipGenerator payslipGenerator = new PayslipGenerator();
        payslipGenerator.generatePayslip(employee);
    }

}
