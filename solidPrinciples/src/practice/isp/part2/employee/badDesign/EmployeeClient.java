package practice.isp.part2.employee.badDesign;

public class EmployeeClient {
    public static void main(String[] args) {
        Employee developer = new Developer();
        developer.work();
        developer.eat();
        developer.sleep();

        System.out.println("----------------");

        developer.manageTeam();
        developer.approveLeave();
        developer.generateReports();
    }
}